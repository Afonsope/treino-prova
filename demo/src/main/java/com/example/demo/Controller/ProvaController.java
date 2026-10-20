package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Entities.ProvaEntity;
import com.example.demo.Service.ProvaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Provas")
public class ProvaController {

    private final ProvaService service;

    public ProvaController(ProvaService service) {
        this.service = service;
    }

    @PostMapping
    public ProvaEntity salvar(@RequestBody ProvaEntity prova) {
        return service.salvar(prova);
    }

    @GetMapping
    public List<ProvaEntity> listarTodos() {
        return service.listarTodos();
    } 

    @PutMapping("/{codigo}")
    public ProvaEntity atualizar(@PathVariable int codigo, @RequestBody ProvaEntity prova) {
        return service.atualizar(codigo, prova);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable int codigo) {
        service.deletar(codigo);
    }
    
}
