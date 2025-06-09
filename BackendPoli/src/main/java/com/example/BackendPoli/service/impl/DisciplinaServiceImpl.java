package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.DisciplinaRequest;
import com.example.BackendPoli.Model.dto.response.DisciplinaResponse;
import com.example.BackendPoli.Model.entity.Disciplina;
import com.example.BackendPoli.repository.DisciplinaRepository;
import com.example.BackendPoli.service.interfaces.DisciplinaService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Builder

@Service
@RequiredArgsConstructor
public abstract class DisciplinaServiceImpl implements DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public DisciplinaResponse criarDisciplina(DisciplinaRequest request){
        Disciplina disciplina = Disciplina.builder()
        .nomeDisciplina(request.getNomeDisciplina())
                .build();
            disciplinaRepository.save(disciplina);
            return mapToResponse(disciplina);
    }

    @Override
    public DisciplinaResponse atualizarDisciplina(Long id, Disciplina request){
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Disciplina não encontrada"));
        disciplina.setNomeDisciplina(request.getNomeDisciplina());
        return mapToResponse(disciplina);
    }

    @Override
    public void deletarDisciplina(Long id){
        disciplinaRepository.deleteById(id);
    }

    @Override
    public DisciplinaResponse buscarPorId(Long id){
        Disciplina disciplina = disciplinaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Disciplina não encontrada"));
            return mapToResponse(disciplina);
    }
    public List<DisciplinaResponse> listarTodos(){
        return disciplinaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private DisciplinaResponse mapToResponse(Disciplina disciplina){
        DisciplinaResponse response = new DisciplinaResponse();
        response.setId(disciplina.getId());
        response.setNome(disciplina.getNomeDisciplina());
        return response;
    }
}
