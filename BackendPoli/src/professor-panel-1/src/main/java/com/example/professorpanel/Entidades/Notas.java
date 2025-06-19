package com.example.Professor.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



public class Notas {

    @Id

    private Long id_aluno;
    private Long id_disciplina;
    private Integer trimestre;
    private Double nota_1;
    private Double nota_2;
    private Double nota_3;
    private Double media_trimestral;
    private Double nota_mac;
}
