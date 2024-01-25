package com.project;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId", unique = true, nullable = false)
    private Long personaId;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "telefon", nullable = false)
    private String telefon;

    @ManyToMany
    @JoinTable(
            name = "prestecs",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "llibre_id")
    )
    private Set<Llibre> llibres;

    // Constructors, getters i setters

    public Persona() {}

    public Persona(String dni, String nom, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public String toString() {
        return "Persona: " + this.nom + " (" + this.dni + ")";
    }
}

