package com.example.BackendPoli.Model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private int numero_passe;
}
