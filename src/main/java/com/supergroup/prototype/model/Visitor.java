package com.supergroup.prototype.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private LocalDateTime dateAndTime; // TODO: Skal bruges til timestamp
    private String gender = "female"; // Female as default value
    private String language = "Danish"; // Danish as default value
    private String ageGroup = "60+"; // 60+ as default
    private int groupSize = 2; // 2 as default

    public Visitor() {
    }

}
