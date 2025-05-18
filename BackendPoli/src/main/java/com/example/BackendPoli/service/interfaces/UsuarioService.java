package com.example.BackendPoli.service.interfaces;
import com.example.BackendPoli.Model.dto.request.UsuarioRequest;
import com.example.BackendPoli.Model.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse criarUsuario(UsuarioRequest request);
    UsuarioResponse atualizarUsuario(Long id, UsuarioRequest request);
    void deletarUsuario(Long id);
    UsuarioResponse buscaPorID(Long id);
    List<UsuarioResponse> listarTodos();
}
