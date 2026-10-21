package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok gera getters, setters, toString, equals e hashCode para os campos.
@Data
// Gera construtor com todos os campos e construtor sem argumentos (útil para JPA).
@AllArgsConstructor
@NoArgsConstructor
// Indica ao JPA que esta classe representa uma entidade persistida no banco.
@Entity
// Define o nome da tabela correspondente no banco de dados.
@Table(name = "Provas")
public class ProvaEntity {

    // Identificador da entidade; o banco gera o valor ao inserir uma nova linha.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Mapeia o atributo codigo para a coluna CODIGO.
    @Column(name = "CODIGO")
    private int codigo;

    // Nome da prova, limitado a 100 caracteres e obrigatório no banco.
    @Column(name = "NOME", length = 100, nullable = false)
    private String Nome;

    // Nota da prova; nullable=false exige um valor no banco.
    @Column(name = "NOTA", nullable = false)
    private float nota;

    // Situação textual da prova, limitada a 255 caracteres e obrigatória.
    @Column(name = "STATUS", length = 255, nullable = false)
    private String status;

}
