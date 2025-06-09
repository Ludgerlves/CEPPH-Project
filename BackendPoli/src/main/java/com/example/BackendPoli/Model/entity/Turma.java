package com.example.BackendPoli.Model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "Turmas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private Integer anoLetivo;

    @NotBlank
    private String nivelEnsino;

    @NotBlank
    private String periodo;

    @NotBlank
    private String classe;

    private String curso;

//@ManyToOne
  //  private Professor Coordenador;
//@OneToMany(mappedBy = "turma")
    //private List<Aluno> alunos;

}
