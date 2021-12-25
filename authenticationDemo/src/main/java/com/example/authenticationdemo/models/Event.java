package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    int id;
    String name;
    int gePoint;
    int capacity;
    boolean isPassed;
    boolean isOnline;
    int budget;


    public Event() {

    }



    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id")
    private Club dependentClub;

    @ManyToMany
    @JoinTable(
            name = "student_registeredToEvent",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> registeredStudents = new HashSet<>();

    public Set<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Set<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", dependentClub=" + dependentClub +
                '}';
    }

    public Club getDependentClub() {
        return dependentClub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDependentClub(Club dependentClub) {
        this.dependentClub = dependentClub;
    }

    public void assignClub(Club club) {
        this.dependentClub = dependentClub;//assigning the event to club
    }

    public void registerStudentToEvent(Student student){
        registeredStudents.add(student);
    }
}
