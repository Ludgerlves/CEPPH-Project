package com.example.BackendPoli.Model.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse {
    private Long id;
    private String nomeCompleto;
    private String numeroProcesso;
}
