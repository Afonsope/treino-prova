package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.ProvaEntity;
import com.example.demo.Repository.ProvaRepository;

@Service
public class ProvaService {

    private final ProvaRepository repository;

    public ProvaService(ProvaRepository repository) {
        this.repository = repository;
    }

    public ProvaEntity salvar(ProvaEntity prova) {
        return repository.save(prova);
    }

    public List<ProvaEntity> listarTodos() {
        return repository.findAll();
    }

    public ProvaEntity atualizar(int codigo, ProvaEntity prova) {
        ProvaEntity provaExistente = repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        provaExistente.setNome(prova.getNome());
        provaExistente.setNota(prova.getNota());
        provaExistente.setStatus(prova.getStatus());

        return repository.save(provaExistente);
    }

    public void deletar(int codigo) {
        ProvaEntity provaExistente = repository.findById(codigo).orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        repository.delete(prova);
    }
}
