package com.example.BackendPoli.Controller.admin;

import com.example.BackendPoli.Model.dto.request.DisciplinaRequest;
import com.example.BackendPoli.Model.dto.response.DisciplinaResponse;
import com.example.BackendPoli.service.interfaces.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/disciplinas")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor

public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaResponse> criar(@RequestBody DisciplinaRequest request){
        return ResponseEntity.ok(disciplinaService.criarDisciplina(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> atualizar(@PathVariable Long id, @RequestBody DisciplinaRequest request){
        return ResponseEntity.ok(disciplinaService.atualizarDisciplina(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> apagar(@PathVariable Long id){
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> BuscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> listarTodas(){
        return ResponseEntity.ok(disciplinaService.listarTodas());
    }
}
