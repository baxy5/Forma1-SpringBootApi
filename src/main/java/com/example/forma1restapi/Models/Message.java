package com.example.forma1restapi.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "datum", nullable = false)
    private LocalDateTime datum;

    @Column(name = "kuldo", nullable = false, length = 100)
    private String kuldo;

    @Column(name = "uzenet", nullable = false, columnDefinition = "TEXT")
    private String uzenet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getKuldo() {
        return kuldo;
    }

    public void setKuldo(String kuldo) {
        this.kuldo = kuldo;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }
}
