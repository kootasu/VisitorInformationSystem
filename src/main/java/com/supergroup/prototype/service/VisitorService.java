package com.supergroup.prototype.service;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    public Set<Visitor> findAll(){
        Set<Visitor> visitors = new HashSet<>();
        for (Visitor visitor : visitorRepository.findAll()) {
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
        visitor.setInLargeGroup(0);
        return visitorRepository.save(visitor);
    }

    public List<Visitor> createGroupVisitor(Visitor visitor, int quantity){
        List<Visitor> temp = new ArrayList<>();
        for (int i = 0; i <quantity ; i++) {
            if(visitor.getGender() == null){ visitor.setGender("Ukendt");
            }
            if(visitor.getAgeGroup() == null){ visitor.setAgeGroup("Ukendt");
            }
            if(visitor.getLanguage()==null){ visitor.setLanguage("Ukendt");
            }
            if(quantity>=6){ visitor.setInLargeGroup(0);
            }else{
                visitor.setInLargeGroup(0);
            }
            visitor.setGroupSize(quantity);
            temp.add(new Visitor(visitor.getDateAndTime(),visitor.getGender(),visitor.getLanguage(),visitor.getAgeGroup(),visitor.getGroupSize(),visitor.getInLargeGroup()));
        }
            return (List<Visitor>) visitorRepository.saveAll(temp);
    }

    public Visitor update(Visitor visitor){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return visitorRepository.save(visitor);
    }

    public void deleteById(Long id){
        visitorRepository.deleteById(id);
    }

}
