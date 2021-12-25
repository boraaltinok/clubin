package com.example.authenticationdemo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue( value = "SPECIFIC_EVENT_NOTIFICATION")
public class SpecificEventNotification extends Notification{

    @OneToOne(mappedBy = "specificEventNotification")
    Event event;

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }
}
