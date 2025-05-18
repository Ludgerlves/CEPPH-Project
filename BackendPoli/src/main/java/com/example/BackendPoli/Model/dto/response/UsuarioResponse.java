package com.example.BackendPoli.Model.dto.response;
import com.example.BackendPoli.Model.enums.PerfilUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private int numero_passe;
    private PerfilUsuario perfil;
}
