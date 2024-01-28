package com.project;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "Llibre",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"nom", "editorial"})})
public class Llibre implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="llibreId", unique=true, nullable=false)
    private Long llibreId;

    @Column(name="nom", nullable=false)
    private String nom;
    @Column(name="editorial", nullable=false)
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

    // Constructors, getters i setters

    public Llibre() {}

    public Llibre(String nom, String editorial) {
        this.nom = nom;
        this.editorial = editorial;
    }

    public Long getLlibreId() {
        return llibreId;
    }

    public String getNom() {
        return nom;
    }

    public String getEditorial() {
        return editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public Set<Biblioteca> getBiblioteques() {
        return biblioteques;
    }

    public Set<Persona> getPersones() {
        return persones;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setBiblioteques(Set<Biblioteca> biblioteques) {
        this.biblioteques = biblioteques;
    }

    public void setPersones(Set<Persona> persones) {
        this.persones = persones;
    }
    
    public String toString() {
        return "Llibre: " + this.nom + " (" + this.editorial + ")";
    }
}
