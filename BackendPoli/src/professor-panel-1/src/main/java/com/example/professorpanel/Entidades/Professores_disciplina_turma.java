package com.example.Professor.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Professores_disciplina_turma {

    @Id

    private Long id_professor;
    private Long id_disciplina;
    private Long id_turma;
}
