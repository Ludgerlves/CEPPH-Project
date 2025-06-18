package com.example.BackendPoli.service.interfaces;

import com.example.BackendPoli.Model.dto.request.AlunoRequest;
import com.example.BackendPoli.Model.dto.response.AlunoResponse;

import java.util.List;

public interface AlunoService {
    List<AlunoResponse> getAll();
    AlunoResponse findById(Long id);
    AlunoResponse save(AlunoRequest request);
    AlunoResponse delete(Long id);
    List<AlunoResponse> buscarPorNome(String nome);
}
