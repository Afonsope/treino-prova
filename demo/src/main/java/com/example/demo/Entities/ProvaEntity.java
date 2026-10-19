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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Provas")
public class ProvaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "NOME", length = 100, nullable = false)
    private String Nome;

    @Column(name = "NOTA", nullable = false)
    private float nota;

    @Column(name = "STATUS", length = 255, nullable = false)
    private String status;

}
