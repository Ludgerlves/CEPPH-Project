package com.example.BackendPoli.Controller.admin;

import com.example.BackendPoli.Model.dto.request.TurmaRequest;
import com.example.BackendPoli.Model.dto.response.TurmaResponse;
import com.example.BackendPoli.service.interfaces.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/turmas")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class TurmasController {

    private final TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaResponse> criar(@RequestBody TurmaRequest request){
        return ResponseEntity.ok(turmaService.criarTurma(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponse> atualizar(@PathVariable Long id, @RequestBody TurmaRequest request){
        return ResponseEntity.ok(turmaService.atualizarTurma(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        turmaService.apagarTurma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponse> BuscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(turmaService.BuscarPorId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TurmaResponse>> listarTodas(){
        return ResponseEntity.ok(turmaService.listarTodas());
    }

}
