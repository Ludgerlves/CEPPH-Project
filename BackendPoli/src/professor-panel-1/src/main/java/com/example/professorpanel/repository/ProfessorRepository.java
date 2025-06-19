package com.example.professorpanel.repository;

import com.example.professorpanel.model.Nota;
import com.example.professorpanel.model.Presenca;
import com.example.professorpanel.model.Atividade;
import com.example.professorpanel.model.Material;
import com.example.professorpanel.model.Calendario;
import com.example.professorpanel.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Nota, Long> {
    JpaRepository<Presenca, Long> presencaRepository();
    JpaRepository<Atividade, Long> atividadeRepository();
    JpaRepository<Material, Long> materialRepository();
    JpaRepository<Calendario, Long> calendarioRepository();
    JpaRepository<Mensagem, Long> mensagemRepository();
}