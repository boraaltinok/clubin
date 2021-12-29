package com.example.authenticationdemo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue( value = "SPECIFIC_EVENT_NOTIFICATION")
public class SpecificEventNotification extends Notification{

    String clubName;
    String eventName;
    String eventDescription;

    public SpecificEventNotification(){
        visibility = true;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }


}
