package com.example.BackendPoli.Model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "Disciplina")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeDisciplina;
}
