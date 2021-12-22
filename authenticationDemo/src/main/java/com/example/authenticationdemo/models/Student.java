package com.example.authenticationdemo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    long id;
    String ROLE;
    int gePoints;
    boolean isTakingGeCourse;

    public int getGePoints() {
        return gePoints;
    }

    public void setGePoints(int gePoints) {
        this.gePoints = gePoints;
    }

    public boolean isTakingGeCourse() {
        return isTakingGeCourse;
    }

    public void setTakingGeCourse(boolean takingGeCourse) {
        isTakingGeCourse = takingGeCourse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }
}
