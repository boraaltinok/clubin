package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "CLUB_MANAGER")
public class ClubManager extends User{

    @JsonIgnore
    @OneToOne(mappedBy = "clubManager",cascade = CascadeType.ALL)
    @JoinColumn
    private Club myClub;

    @OneToMany(mappedBy = "clubManager", cascade = CascadeType.REMOVE)
    private Set<CreateEventForm> createdEventForm = new HashSet<>();

    public Club getMyClub() {
        return myClub;
    }

    public void setMyClub(Club myClub) {
        this.myClub = myClub;
    }

    public Set<CreateEventForm> getCreatedEventForm() {
        return createdEventForm;
    }

    public void setCreatedEventForm(Set<CreateEventForm> createdEventForm) {
        this.createdEventForm = createdEventForm;
    }
}
