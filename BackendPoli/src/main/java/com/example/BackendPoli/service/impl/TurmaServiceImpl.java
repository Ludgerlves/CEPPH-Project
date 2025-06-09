package com.example.BackendPoli.service.impl;

import com.example.BackendPoli.Model.dto.request.TurmaRequest;
import com.example.BackendPoli.Model.dto.response.TurmaResponse;
import com.example.BackendPoli.Model.entity.Turma;
import com.example.BackendPoli.repository.TurmaRepository;
import com.example.BackendPoli.service.interfaces.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public abstract class TurmaServiceImpl implements TurmaService {
   private final TurmaRepository turmaRepository;

    @Override
    public TurmaResponse criarTurma(TurmaRequest request){
        Turma turma = Turma.builder()
                .nome(request.getNome())
                .anoLetivo(request.getAnoLetivo())
                .classe(request.getClasse())
                .curso(request.getCurso())
                .periodo(request.getPeriodo())
                .nivelEnsino(request.getNivelEnsino())
                .build();
        turmaRepository.save(turma);
        return mapToResponse(turma);

    }

    @Override
    public TurmaResponse atualizarTurma(Long id, TurmaRequest request){
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Turma não encontrada"));
        turma.setNome(request.getNome());
        turma.setAnoLetivo(request.getAnoLetivo());
        turma.setClasse(request.getClasse());
        turma.setCurso(request.getCurso());
        turma.setPeriodo(request.getPeriodo());
        turma.setNivelEnsino(request.getNivelEnsino());
        turmaRepository.save(turma);
        return mapToResponse(turma);
    }

    @Override
    public void apagarTurma(Long id){
        turmaRepository.deleteById(id);
    }
    @Override
    public TurmaResponse BuscarPorId(Long id){
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Turma não encontrada"));
        return mapToResponse(turma);
    }

    @Override
    public List<TurmaResponse> listarTodas() {
        return turmaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TurmaResponse mapToResponse(Turma turma) {
        TurmaResponse response = new TurmaResponse();
        turma.setNome(response.getNome());
        turma.setAnoLetivo(response.getAnoLetivo());
        turma.setClasse(response.getClasse());
        turma.setCurso(response.getCurso());
        turma.setPeriodo(response.getPeriodo());
        turma.setNivelEnsino(response.getNivelEnsino());
        return response;
    }


}
