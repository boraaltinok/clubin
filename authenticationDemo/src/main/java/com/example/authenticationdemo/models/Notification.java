package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name ="notifications")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "NOTIFICATION_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Notification {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    Event event;

    public Notification(){

    }
    public Notification(boolean visibility) {
        this.visibility = visibility;

    }

    boolean visibility;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
