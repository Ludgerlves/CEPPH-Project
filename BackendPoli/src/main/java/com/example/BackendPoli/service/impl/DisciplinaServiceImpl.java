package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.DisciplinaRequest;
import com.example.BackendPoli.Model.dto.response.DisciplinaResponse;
import com.example.BackendPoli.Model.entity.Disciplina;
import com.example.BackendPoli.repository.DisciplinaRepository;
import com.example.BackendPoli.service.interfaces.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public abstract class DisciplinaServiceImpl implements DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public DisciplinaResponse criarDisciplina(DisciplinaRequest request){
        Disciplina disciplina = Disciplina.builder();
            .nome(request.getNome());
            .build();
            disciplinaRepository.save(disciplina);
            return mapToResponse(disciplina);
    }

    @Override
    public DisciplinaResponse atualizarDisciplina(Long id, Disciplina request){
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Disciplina não encontrada"));
        disciplina.setNomeDisciplina();
    }
}
