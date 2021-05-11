package com.supergroup.prototype.service;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    public Set<Visitor> findAll(){
        Set<Visitor> visitors = new HashSet<>();
        for (Visitor visitor : visitors) {
            visitors.add(visitor);
        }
        return visitors;
    }

    public Visitor findById(Long id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Visitor> optionalVisitor = visitorRepository.findById(id);
        if (!optionalVisitor.isPresent()){
            throw new RuntimeException("Visitor " + id + " not found");
        }
        //returner indhold af optional vha. get()
        return optionalVisitor.get();
    }

    public Visitor create(Visitor visitor){
        return visitorRepository.save(visitor);
    }

    public Visitor update(Visitor visitor){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return visitorRepository.save(visitor);
    }

    public void deleteById(Long id){
        visitorRepository.deleteById(id);
    }

}
