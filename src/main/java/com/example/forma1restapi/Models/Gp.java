package com.example.forma1restapi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "gp")
public class Gp {

    @Id
    @Column(name = "datum", nullable = false)
    private LocalDate date;

    @Column(name = "nev", nullable = false, length = 100)
    private String nev;

    @Column(name = "helyszin", nullable = false, length = 100)
    private String helyszin;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }
}
