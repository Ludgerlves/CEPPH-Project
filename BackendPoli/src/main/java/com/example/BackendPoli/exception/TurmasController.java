package com.example.BackendPoli.controller;

import com.example.BackendPoli.Model.dto.response.TurmaResponse;
import com.example.BackendPoli.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmasController {
    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> listarTodas() {
        return ResponseEntity.ok(turmaService.listarTodas());
    }

    // Outros métodos mantidos...
}
