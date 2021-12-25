package com.example.authenticationdemo.models;

import javax.persistence.*;

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

    public Notification(){

    }
    public Notification(boolean visibility, Event event) {
        this.visibility = visibility;
        this.event = event;
    }

    boolean visibility;

    @OneToOne
    Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

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
}
