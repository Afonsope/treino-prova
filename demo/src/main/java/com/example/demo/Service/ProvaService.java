package com.example.demo.Service;

import java.util.Map;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.ProvaEntity;
import com.example.demo.Repository.ProvaRepository;

// Camada de serviço: centraliza operações e regras entre o Controller e o Repository.
@Service
public class ProvaService {

    // Repositório responsável pela comunicação com o banco via Spring Data JPA.
    private final ProvaRepository repository;

    // O Spring injeta o repositório pelo construtor.
    public ProvaService(ProvaRepository repository) {
        this.repository = repository;
    }

    // Persiste a prova; save insere quando não há identificador existente.
    public ProvaEntity salvar(ProvaEntity prova) {
        return repository.save(prova);
    }

    // Busca todas as entidades e devolve a lista ao Controller.
    public List<ProvaEntity> listarTodos() {
        return repository.findAll();
    }

    // Busca uma prova pelo código; se não houver resultado, lança uma exceção em vez de retornar null.
    public ProvaEntity buscarPorId(int codigo) {
        return repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrado"));
    }

    // Localiza a prova pelo código; se não existir, interrompe a operação com uma exceção.
    public ProvaEntity atualizar(int codigo, ProvaEntity prova) {
        ProvaEntity provaExistente = repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        // Copia os campos editáveis para a entidade já persistida.
        // Mantém o identificador original, evitando tratar a atualização como outra prova.
        provaExistente.setNome(prova.getNome());
        provaExistente.setNota(prova.getNota());
        provaExistente.setStatus(prova.getStatus());

        // Salva as alterações e devolve a versão atualizada.
        return repository.save(provaExistente);
    }

    // Atualiza somente os campos enviados na requisição, preservando os demais valores da prova.
    public ProvaEntity atualizarParcial(int codigo, Map<String, Object> dados) {
        // Localiza a prova que será alterada; se ela não existir, interrompe a operação.
        ProvaEntity prova = repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        // Altera cada campo apenas quando ele foi incluído no corpo da requisição.
        if(dados.containsKey("nome")) {
            prova.setNome((String) dados.get("nome"));
        }

        if(dados.containsKey("nota")) {
            // Converte o valor numérico recebido para o tipo usado pela entidade.
            prova.setNota(((Number) dados.get("nota")).floatValue());
        }

        if(dados.containsKey("status")) {
            prova.setStatus((String) dados.get("status"));
        }

        // Persiste e retorna a prova com os campos atualizados.
        return repository.save(prova);
    }

    // Confirma que a prova existe antes de excluí-la.
    public void deletar(int codigo) {
        ProvaEntity provaExistente = repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        // Remove do banco a entidade localizada.
        repository.delete(provaExistente);
    }
}