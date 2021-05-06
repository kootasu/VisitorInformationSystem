package com.supergroup.prototype.service;

import com.supergroup.prototype.model.Visitor;
import com.supergroup.prototype.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

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

}
