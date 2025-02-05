package org.generation.jaita138.demo6.demo6.db.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class SubReddit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 64)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descrizione;

    public Long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "subRedditS")
    private List<Utente> utenti;


    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public String toString() {
        return "SubReddit [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + "]";
    }

    

}
