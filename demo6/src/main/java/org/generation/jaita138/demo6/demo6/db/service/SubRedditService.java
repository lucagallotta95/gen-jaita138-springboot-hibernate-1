package org.generation.jaita138.demo6.demo6.db.service;

import java.util.List;
import java.util.Optional;

import org.generation.jaita138.demo6.demo6.db.entity.SubReddit;
import org.generation.jaita138.demo6.demo6.db.repo.SubRedditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRedditService {

    @Autowired
    private SubRedditRepo subRedditRepo;

    public void save(SubReddit entity) {
        subRedditRepo.save(entity);
    }

    public List<SubReddit> findAll() {
        return subRedditRepo.findAll();
    }

    public Optional<SubReddit> findById(Long id) {
        return subRedditRepo.findById(id);
    }

    public void delete(SubReddit entity) {
        subRedditRepo.delete(entity);
    }

    
}
