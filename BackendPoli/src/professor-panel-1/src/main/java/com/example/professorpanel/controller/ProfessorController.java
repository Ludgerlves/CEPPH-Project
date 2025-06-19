package com.example.professorpanel.controller;

import com.example.professorpanel.model.Nota;
import com.example.professorpanel.model.Presenca;
import com.example.professorpanel.model.Atividade;
import com.example.professorpanel.model.Material;
import com.example.professorpanel.model.Calendario;
import com.example.professorpanel.model.Mensagem;
import com.example.professorpanel.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/notas")
    public ResponseEntity<Nota> postNotas(@RequestBody Nota nota) {
        Nota savedNota = professorService.saveNota(nota);
        return ResponseEntity.ok(savedNota);
    }

    @PostMapping("/presencas")
    public ResponseEntity<Presenca> postPresencas(@RequestBody Presenca presenca) {
        Presenca savedPresenca = professorService.savePresenca(presenca);
        return ResponseEntity.ok(savedPresenca);
    }

    @PostMapping("/atividades")
    public ResponseEntity<Atividade> postAtividades(@RequestBody Atividade atividade) {
        Atividade savedAtividade = professorService.saveAtividade(atividade);
        return ResponseEntity.ok(savedAtividade);
    }

    @PostMapping("/materiais/upload")
    public ResponseEntity<Material> postMateriaisUpload(@RequestBody Material material) {
        Material savedMaterial = professorService.uploadMaterial(material);
        return ResponseEntity.ok(savedMaterial);
    }

    @GetMapping("/calendario")
    public ResponseEntity<Calendario> getCalendario() {
        Calendario calendario = professorService.getCalendario();
        return ResponseEntity.ok(calendario);
    }

    @PostMapping("/mensagens")
    public ResponseEntity<Mensagem> postMensagens(@RequestBody Mensagem mensagem) {
        Mensagem savedMensagem = professorService.saveMensagem(mensagem);
        return ResponseEntity.ok(savedMensagem);
    }
}