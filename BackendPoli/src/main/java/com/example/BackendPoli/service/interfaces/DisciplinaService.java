package com.example.BackendPoli.service.interfaces;
import com.example.BackendPoli.Model.dto.request.DisciplinaRequest;
import com.example.BackendPoli.Model.dto.response.DisciplinaResponse;
import com.example.BackendPoli.Model.entity.Disciplina;

import java.util.List;
public interface DisciplinaService {
    DisciplinaResponse criarDisciplina(DisciplinaRequest request);
    DisciplinaResponse atualizarDisciplina(Long id, DisciplinaRequest request);
    void apagarDisciplina(Long id);
    DisciplinaResponse buscarPorId(Long id);
    List<DisciplinaResponse> listarTodas();
}
