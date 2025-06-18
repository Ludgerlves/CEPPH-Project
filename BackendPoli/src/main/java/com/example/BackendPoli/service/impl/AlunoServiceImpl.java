package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.AlunoRequest;
import com.example.BackendPoli.Model.dto.response.AlunoResponse;
import com.example.BackendPoli.Model.entity.Aluno;
import com.example.BackendPoli.Model.entity.Turma;
import com.example.BackendPoli.repository.AlunoRepository;
import com.example.BackendPoli.repository.TurmaRepository;
import com.example.BackendPoli.service.interfaces.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<AlunoResponse> getAll() {
        return alunoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AlunoResponse findById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponse(aluno);
    }

    @Override
    public AlunoResponse save(AlunoRequest request) {
        Turma turma = turmaRepository.findById(request.getIdTurma())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(request.getNomeCompleto());
        aluno.setNumeroProcesso(request.getNumeroProcesso());
        aluno.setTurma(turma);

        Aluno salvo = alunoRepository.save(aluno);
        return toResponse(salvo);
    }

    @Override
    public AlunoResponse delete(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoRepository.delete(aluno);
        return toResponse(aluno);
    }

    @Override
    public List<AlunoResponse> buscarPorNome(String nome) {
        return alunoRepository.findByNomeCompletoContainingIgnoreCase(nome).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private AlunoResponse toResponse(Aluno aluno) {
        AlunoResponse dto = new AlunoResponse();
        dto.setId(aluno.getId());
        dto.setNomeCompleto(aluno.getNomeCompleto());
        dto.setNumeroProcesso(aluno.getNumeroProcesso());
        return dto;
    }
}