package com.example.forma1restapi.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pilota")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer az;

    @Column(name = "nev", nullable = false, length = 100)
    private String nev;

    @Column(name = "nem", nullable = true, length = 1, columnDefinition = "CHAR(1)")
    private String nem;

    @Column(name = "szuldat", nullable = false)
    private LocalDate szuldat;

    @Column(name = "nemzet", nullable = false, length = 100)
    private String nemzet;

    public Integer getAz() {
        return az;
    }

    public void setAz(Integer az) {
        this.az = az;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public LocalDate getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(LocalDate szuldat) {
        this.szuldat = szuldat;
    }

    public String getNemzet() {
        return nemzet;
    }

    public void setNemzet(String nemzet) {
        this.nemzet = nemzet;
    }
}
