/*package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.UsuarioRequest;
import com.example.BackendPoli.Model.dto.response.UsuarioResponse;
import com.example.BackendPoli.Model.entity.Usuario;
import com.example.BackendPoli.exceptions.ConflictException;
import com.example.BackendPoli.exceptions.ResourceNotFoundException;
import com.example.BackendPoli.exceptions.ValidationException;
import com.example.BackendPoli.repository.UsuarioRepository;
import com.example.BackendPoli.service.interfaces.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse criarUsuario(UsuarioRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("Já existe um usuário com este email");
        }
        
        if (request.getSenha() == null || request.getSenha().length() < 6) {
            throw new ValidationException("A senha deve ter pelo menos 6 caracteres");
        }
        
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
            .orElseThrow(() -> new ResourceNotFoundException("Usuário", id));
            
        if (!usuario.getEmail().equals(request.getEmail()) {
            if (usuarioRepository.existsByEmail(request.getEmail())) {
                throw new ConflictException("Já existe um usuário com este email");
            }
        }
        
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setPerfil(request.getPerfil());
        
        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário", id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponse buscaPorID(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário", id));
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
            .numero_passe(usuario.getNumero_passe())
            .perfil(usuario.getPerfil())
            .build();
    }
}
*/