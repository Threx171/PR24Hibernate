package com.project;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Biblioteca") 
public class Biblioteca implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bibliotecaId", unique = true, nullable = false)
    private Long bibliotecaId;

    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "ciutat", nullable = false)
    private String ciutat;

    @ManyToMany
    @JoinTable(
    name = "Llibre_Biblioteca",
    joinColumns = @JoinColumn(name = "bibliotecaId"),
    inverseJoinColumns = @JoinColumn(name = "llibreId")
    )
    private Set<Llibre> llibres;

    // Constructors, getters i setters

    public Biblioteca() {}

    public Biblioteca(String nom, String ciutat) {
        this.nom = nom;
        this.ciutat = ciutat;
    }

    public Long getBibliotecaId() {
        return bibliotecaId;
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

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String toString() {
        return "Biblioteca: " + this.nom + " (" + this.ciutat + ")";
    }
}

