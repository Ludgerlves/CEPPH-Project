package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.DisciplinaRequest;
import com.example.BackendPoli.Model.dto.response.DisciplinaResponse;
import com.example.BackendPoli.Model.entity.Disciplina;
import com.example.BackendPoli.exceptions.*;
import com.example.BackendPoli.repository.DisciplinaRepository;
import com.example.BackendPoli.service.interfaces.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public DisciplinaResponse criarDisciplina(DisciplinaRequest request) {
        if (request.getNomeDisciplina() == null || request.getNomeDisciplina().trim().isEmpty()) {
            throw new ValidationException("nomeDisciplina", "não pode estar vazio");
        }
        
        if (disciplinaRepository.existsByNomeDisciplina(request.getNomeDisciplina())) {
            throw new ConflictException("disciplina", "nome", request.getNomeDisciplina());
        }
        
        Disciplina disciplina = Disciplina.builder()
            .nomeDisciplina(request.getNomeDisciplina().trim())
            .build();
            
        return mapToResponse(disciplinaRepository.save(disciplina));
    }

    @Override
    public DisciplinaResponse atualizarDisciplina(Long id, DisciplinaRequest request) {
        Disciplina disciplina = disciplinaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disciplina", id));
            
        if (request.getNomeDisciplina() == null || request.getNomeDisciplina().trim().isEmpty()) {
            throw new ValidationException("nomeDisciplina", "não pode estar vazio");
        }
        
        if (!disciplina.getNomeDisciplina().equals(request.getNomeDisciplina()) &&
            disciplinaRepository.existsByNomeDisciplina(request.getNomeDisciplina())) {
            throw new ConflictException("disciplina", "nome", request.getNomeDisciplina());
        }
        
        disciplina.setNomeDisciplina(request.getNomeDisciplina().trim());
        return mapToResponse(disciplinaRepository.save(disciplina));
    }

    @Override
    public void deletarDisciplina(Long id) {
        if (!disciplinaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Disciplina", id);
        }
        disciplinaRepository.deleteById(id);
    }

    @Override
    public DisciplinaResponse buscarPorId(Long id) {
        return mapToResponse(disciplinaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disciplina", id)));
    }

    @Override
    public List<DisciplinaResponse> listarTodas() {
        return disciplinaRepository.findAll().stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    private DisciplinaResponse mapToResponse(Disciplina disciplina) {
        return DisciplinaResponse.builder()
            .id(disciplina.getId())
            .nome(disciplina.getNomeDisciplina())
            .build();
    }
}
