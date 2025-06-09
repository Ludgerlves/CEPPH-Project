package com.example.BackendPoli.Model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplinaResponse {
    private Long id;
    private String nome;
    public DisciplinaResponse(){
        this.id= id;
        this.nome= nome;
    }
}
