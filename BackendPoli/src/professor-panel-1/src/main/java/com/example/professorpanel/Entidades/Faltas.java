package com.example.Professor.Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity

public class Faltas {

    @Id

    private Long  id_alauno;
    private Long id_disciplina;
    private Date data_falta;
    private Boolean justificada;
}
