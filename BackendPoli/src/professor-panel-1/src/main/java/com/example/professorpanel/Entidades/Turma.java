package com.example.Professor.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Turma {
    @Id
    private Long id_classe;
    private String nome;
    private Integer ano_letivo;
}
