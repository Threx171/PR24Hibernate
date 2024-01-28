package com.project;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Autor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autorId", unique = true, nullable = false)
    private Long autorId;

    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany
    @JoinColumn(name = "autorId") 
    private Set<Llibre> llibres;

    // Constructors, getters i setters

    public Autor() {}

    public Autor(String nom) {
        this.nom = nom;
    }


    public Long getAutorId() {
        return autorId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public void addLlibre(Llibre llibre) {
        this.llibres.add(llibre);
    }

    public String toString() {
        return "Autor: " + this.nom;
    }
}
