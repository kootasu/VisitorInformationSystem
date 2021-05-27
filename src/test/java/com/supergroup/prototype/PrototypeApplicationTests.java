package com.supergroup.prototype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.mockito.MockitoFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.supergroup.prototype.repository.VisitorRepository;
import com.supergroup.prototype.model.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PrototypeApplicationTests {

    @Autowired
    VisitorRepository visitorRepo;

    @Test
    @Order(1)
    public void testCreate() {

        Date date = new Date();

        Visitor  visitor=new Visitor();
        visitor.setAgeGroup("55+");
        visitor.setDateAndTime(date);
        visitor.setGender("female");
        visitor.setLanguage("Danish");
        visitor.setInLargeGroup(0);
        visitor.setGuided_Tour("Ingen");
        visitorRepo.save(visitor);

        assertNotNull(visitorRepo.findById(1L).get());
    }

    @Test
    @Order(2)
    public void testReadAll () {
        Iterable<Visitor> list = visitorRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testRead () {
        Visitor visitor = visitorRepo.findById(1L).get();
        assertEquals("Danish", visitor.getLanguage());
    }

    @Test
    @Order(4)
    public void testUpdate () {
        Visitor visitor = visitorRepo.findById(1L).get();
        visitor.setAgeGroup("25");
        visitorRepo.save(visitor);
        assertNotEquals("55+", visitorRepo.findById(1L).get().getAgeGroup());
    }

    @Test
    @Order(5)
    public void testDelete () {
        visitorRepo.deleteById(1L);
        assertThat(visitorRepo.existsById(1L)).isFalse();
    }
}