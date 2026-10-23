package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Entities.ProvaEntity;
import com.example.demo.Service.ProvaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// Controller REST: recebe requisições HTTP e devolve objetos convertidos para JSON.
@RestController
// Define o prefixo comum de todas as rotas desta classe: /Provas.
@RequestMapping("/Provas")
public class ProvaController {

    // O controller delega as regras/operações ao Service, sem acessar o banco diretamente.
    private final ProvaService service;

    // Injeção por construtor: o Spring fornece automaticamente o ProvaService.
    public ProvaController(ProvaService service) {
        this.service = service;
    }

    // POST /Provas: recebe uma prova no corpo JSON e solicita seu cadastro.
    @PostMapping
    public ProvaEntity salvar(@RequestBody ProvaEntity prova) {
        return service.salvar(prova);
    }

    // GET /Provas: consulta e retorna todas as provas cadastradas.
    @GetMapping
    public List<ProvaEntity> listarTodos() {
        return service.listarTodos();
    } 

    // GET /Provas/{id}: extrai o identificador da URL e pede ao Service a prova correspondente.
    @GetMapping("/{id}")
    public ProvaEntity buscarPorId(@PathVariable("id") int codigo) {
        return service.buscarPorId(codigo);
    }

    // PUT /Provas/{codigo}: lê o código da URL e os novos dados do corpo JSON.
    @PutMapping("/{codigo}")
    public ProvaEntity atualizar(@PathVariable int codigo, @RequestBody ProvaEntity prova) {
        return service.atualizar(codigo, prova);
    }
    
    // PATCH /Provas/{codigo}: recebe apenas os campos a alterar no corpo JSON.
    @PatchMapping("/{codigo}")
    public ProvaEntity atualizaParcial(@PathVariable int codigo, @RequestBody Map<String, Object> dados) {
        // Delega ao Service a atualização dos campos enviados e retorna a prova atualizada.
        return service.atualizarParcial(codigo, dados);
    }

    // DELETE /Provas/{codigo}: solicita a exclusão da prova identificada na URL.
    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable int codigo) {
        service.deletar(codigo);
    }
    
}
