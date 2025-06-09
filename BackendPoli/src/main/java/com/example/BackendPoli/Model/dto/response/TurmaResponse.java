package com.example.BackendPoli.Model.dto.response;

import lombok.Data;

@Data
public class TurmaResponse {
    private Long id;
    private String nome;
    private Integer anoLetivo;
    private String curso;
    private String nivelEnsino;
    private String periodo;
    private String classe;
}
