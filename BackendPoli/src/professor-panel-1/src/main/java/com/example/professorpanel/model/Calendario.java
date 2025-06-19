package com.example.professorpanel.model;

import java.time.LocalDate;

public class Calendario {
    private Long id;
    private LocalDate eventDate;
    private String description;

    public Calendario() {
    }

    public Calendario(Long id, LocalDate eventDate, String description) {
        this.id = id;
        this.eventDate = eventDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}