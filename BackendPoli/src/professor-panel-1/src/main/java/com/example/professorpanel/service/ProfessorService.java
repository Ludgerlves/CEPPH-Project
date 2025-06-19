package com.example.professorpanel.service;

import com.example.professorpanel.model.Atividade;
import com.example.professorpanel.model.Calendario;
import com.example.professorpanel.model.Material;
import com.example.professorpanel.model.Mensagem;
import com.example.professorpanel.model.Nota;
import com.example.professorpanel.model.Presenca;
import com.example.professorpanel.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Nota saveNota(Nota nota) {
        return professorRepository.saveNota(nota);
    }

    public Presenca savePresenca(Presenca presenca) {
        return professorRepository.savePresenca(presenca);
    }

    public Atividade createAtividade(Atividade atividade) {
        return professorRepository.saveAtividade(atividade);
    }

    public Material uploadMaterial(Material material) {
        return professorRepository.saveMaterial(material);
    }

    public List<Calendario> getCalendario() {
        return professorRepository.findAllCalendario();
    }

    public Mensagem sendMensagem(Mensagem mensagem) {
        return professorRepository.saveMensagem(mensagem);
    }
}