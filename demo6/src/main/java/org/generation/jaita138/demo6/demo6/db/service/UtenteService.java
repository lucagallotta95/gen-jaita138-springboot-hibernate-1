package org.generation.jaita138.demo6.demo6.db.service;

import java.util.List;

import org.generation.jaita138.demo6.demo6.db.entity.Utente;
import org.generation.jaita138.demo6.demo6.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente utente) {
        utenteRepo.save(utente);
    }

    public List <Utente> findAll() {
        return utenteRepo.findAll();
    }

    
    public Utente findById(Long id) {
        return utenteRepo.findById(id).orElse(null);
    }

    public void delete(Utente utente) {
        utenteRepo.delete(utente);
    }

    public List <Utente> findByNomeStartingWith(String nome) {
        return utenteRepo.findByNomeStartingWith(nome);
    }

    public List <Utente> findByCreditoGreaterThan(int credito) {
        return utenteRepo.findByCreditoGreaterThan(credito);
    }

    public List <Utente> findByCognomeNullOrNomeNull() {
        return utenteRepo.findByCognomeNullOrNomeNull();
    }

    public List <Utente> findByCreditoBetween(int start, int end) {
        return utenteRepo.findByCreditoBetween(start, end);
    }

}
