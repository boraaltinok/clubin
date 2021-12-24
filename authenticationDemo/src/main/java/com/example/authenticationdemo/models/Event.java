package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
}
