package com.example.BackendPoli.Model.dto.request;
import lombok.Data;

@Data
public class TurmaRequest {

    private String nome;
    private Integer anoLetivo;
    private String curso;
    private String nivelEnsino;
    private String periodo;
    private String classe;
}
