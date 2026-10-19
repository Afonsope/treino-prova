package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.List;
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
}
