package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student extends User{
    //@Id
    //int student_id;
    int gePoints;
    boolean takingGeCourse;
    //JoinRequestHandler joinRequest;
    //Set<Event> registeredPublicEvents = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "clubMembers")
    private Set<Club> registeredClubs = new HashSet<>();

    public Student() {

    }

    public Student(int id, String name, String surname, String password, String email, int gePoints, boolean takingGeCourse, Set<Club> registeredClubs) {
        super(id, name, surname, password, email);
        this.gePoints = gePoints;
        this.takingGeCourse = takingGeCourse;
        this.registeredClubs = registeredClubs;
    }

    public Set<Club> getRegisteredClubs() {
        return registeredClubs;
    }

    public void setRegisteredClubs(Set<Club> registeredClubs) {
        this.registeredClubs = registeredClubs;
    }


    /*public int getStudent_id() {
        return student_id;
    }*/

    /*public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }*/

    public int getGePoints() {
        return gePoints;
    }

    public void setGePoints(int gePoints) {
        this.gePoints = gePoints;
    }

    public boolean isTakingGeCourse() {
        return takingGeCourse;
    }

    public void setTakingGeCourse(boolean takingGeCourse) {
        this.takingGeCourse = takingGeCourse;
    }
}
