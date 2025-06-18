package com.example.Professor.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professores {

    @Id

    private Long id_usuario;
    private String nome_completo;
    private String email;
    private Integer telefone;
}
