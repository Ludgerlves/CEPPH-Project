package com.example.BackendPoli.repository;

import com.example.BackendPoli.Model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    List<Aluno> findByNomeCompletoContainingIgnoreCase(String nome);
}
