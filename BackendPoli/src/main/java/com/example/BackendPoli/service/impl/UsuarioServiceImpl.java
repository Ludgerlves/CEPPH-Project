package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.UsuarioRequest;
import com.example.BackendPoli.Model.dto.response.UsuarioResponse;
import com.example.BackendPoli.Model.entity.Usuario;
import com.example.BackendPoli.repository.UsuarioRepository;
import com.example.BackendPoli.service.interfaces.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse criarUsuario(UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
              .senha(passwordEncoder.encode(request.getSenha()))
                .numero_passe(request.getNumero_passe())
                .perfil(request.getPerfil())
                .build();
        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }

    @Override
    public UsuarioResponse atualizarUsuario(Long id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
         usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setPerfil(request.getPerfil());
        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponse buscaPorID(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return mapToResponse(usuario);
    }

    @Override
    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private UsuarioResponse mapToResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .numero_passe(usuario.getNumero_passe())
                .perfil(usuario.getPerfil())
                .build();
    }
}