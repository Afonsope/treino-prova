package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.ProvaEntity;

// JpaRepository fornece operações CRUD prontas (salvar, buscar, listar e excluir).
// ProvaEntity é a entidade gerenciada e Integer é o tipo do seu identificador.
public interface ProvaRepository extends JpaRepository<ProvaEntity, Integer> {

}
