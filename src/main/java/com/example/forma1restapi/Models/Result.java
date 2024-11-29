package com.example.forma1restapi.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eredmeny")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "pilotaaz", nullable = false)
    private Integer pilotaaz;

    @Column(name = "helyezes", nullable = true)
    private Integer helyezes;

    @Column(name = "hiba", length = 255, nullable = true)
    private String hiba;

    @Column(name = "csapat", length = 100, nullable = true)
    private String csapat;

    @Column(name = "tipus", length = 100, nullable = true)
    private String tipus;

    @Column(name = "motor", length = 100, nullable = true)
    private String motor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Integer getPilotaaz() {
        return pilotaaz;
    }

    public void setPilotaaz(Integer pilotaaz) {
        this.pilotaaz = pilotaaz;
    }

    public Integer getHelyezes() {
        return helyezes;
    }

    public void setHelyezes(Integer helyezes) {
        this.helyezes = helyezes;
    }

    public String getHiba() {
        return hiba;
    }

    public void setHiba(String hiba) {
        this.hiba = hiba;
    }

    public String getCsapat() {
        return csapat;
    }

    public void setCsapat(String csapat) {
        this.csapat = csapat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
