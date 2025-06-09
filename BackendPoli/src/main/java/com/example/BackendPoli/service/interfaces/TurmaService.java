package com.example.BackendPoli.service.interfaces;
import com.example.BackendPoli.Model.dto.request.TurmaRequest;
import com.example.BackendPoli.Model.dto.response.TurmaResponse;
import com.example.BackendPoli.Model.entity.Turma;

import java.util.List;
public interface TurmaService {
    TurmaResponse criarTurma(TurmaRequest request);
    TurmaResponse atualizarTurma(Long id, TurmaRequest request);
    void apagarTurma(Long id);
    TurmaResponse BuscarPorId(Long id);

    List<TurmaResponse> listarTodas();

    TurmaResponse mapToResponse(Turma turma);
}
