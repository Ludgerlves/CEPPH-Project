package com.example.BackendPoli.Model.dto.response;
import com.example.BackendPoli.Model.enums.PerfilUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private int numero_passe;
    private PerfilUsuario perfil;
    /*public UsuarioResponse(Long id, String nome, String email, int numero_passe, PerfilUsuario perfil ){
        this.id = id;
        this.nome= nome;
        this.email= email;
        this.numero_passe = numero_passe;
        this.perfil = perfil;
    }*/
}
