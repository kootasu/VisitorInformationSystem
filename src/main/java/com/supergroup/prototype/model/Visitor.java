package com.supergroup.prototype.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date timestamp;
    private String gender;
    private String language;
    private String age_Group;
    private int group_Size;

    public Visitor(Date timestamp, String gender, String language, String age_Group, int group_Size) {
        this.timestamp = timestamp;
        this.gender = gender;
        this.language = language;
        this.age_Group = age_Group;
        this.group_Size = group_Size;
    }

    public Visitor() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAndTime() {
        return timestamp;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.timestamp = timestamp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAgeGroup() {
        return age_Group;
    }

    public void setAgeGroup(String ageGroup) {
        this.age_Group = ageGroup;
    }

    public int getGroupSize() {
        return group_Size;
    }

    public void setGroupSize(int groupSize) {
        this.group_Size = groupSize;
    }
}
