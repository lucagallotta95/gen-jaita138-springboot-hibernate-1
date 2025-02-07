package org.generation.jaita138.demo6.demo6.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String cognome;

    @Column(length = 128)
    private String username;

    @Column(length = 64)
    private String password;

    @ManyToOne
    private Role role;

    @ManyToMany
    private List <SubReddit> subRedditS = new ArrayList<>();




    private int credito;

    public Long getId() {
        return id;
    }

    public List<SubReddit> getSubRedditS() {
        return subRedditS;
    }

    public void setSubRedditS(List<SubReddit> subRedditS) {
        this.subRedditS = subRedditS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    
    @Override
    public String toString() {
        return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
                + password + ", credito=" + credito + ", ruolo=" + role + "]";
    }

  
   

    

}
