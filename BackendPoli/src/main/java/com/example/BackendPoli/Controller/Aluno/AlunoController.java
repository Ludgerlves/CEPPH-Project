package com.example.BackendPoli.Controller.aluno;

import com.example.BackendPoli.Model.dto.request.AlunoRequest;
import com.example.BackendPoli.Model.dto.response.AlunoResponse;
import com.example.BackendPoli.service.interfaces.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService AlunoService;

    @GetMapping
    public List<AlunoResponse> getAll() {
        return AlunoService.getAll();
    }

    @GetMapping("/{id}")
    public AlunoResponse findById(@PathVariable Long id) {
        return AlunoService.findById(id);
    }

    @PostMapping
    public AlunoResponse create(@RequestBody AlunoRequest request) {
        return AlunoService.save(request);
    }

    @DeleteMapping("/{id}")
    public AlunoResponse delete(@PathVariable Long id) {
        return AlunoService.delete(id);
    }

    @GetMapping("/search")
    public List<AlunoResponse> searchByName(@RequestParam(name = "nome") String nome) {
        return AlunoService.buscarPorNome(nome);
    }
}