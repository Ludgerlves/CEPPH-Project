package com.example.BackendPoli.Model.dto.request;

import com.example.BackendPoli.Model.entity.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String numeroProcesso;

    @NotNull
    private Long idTurma;
}