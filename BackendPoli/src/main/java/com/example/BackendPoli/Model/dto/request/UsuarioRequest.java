package com.example.BackendPoli.Model.dto.request;

import com.example.BackendPoli.Model.enums.PerfilUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private int numero_passe;

    @NotNull
    private PerfilUsuario perfil;

    @NotNull
    private String senha;
}
