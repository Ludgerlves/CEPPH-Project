package com.example.Professor.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Materiais_Didaticos {

    @Id

    private Long id_prof_disc_turma;
    private String titulo;
    private String descricao;
    private String caminho;
}
