package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "CLUB_MANAGER")
public class ClubManager extends User{

    @JsonIgnore
    @OneToOne(mappedBy = "clubManager",cascade = CascadeType.ALL)
    @JoinColumn
    private Club myClub;


    public Club getMyClub() {
        return myClub;
    }

    public void setMyClub(Club myClub) {
        this.myClub = myClub;
    }

}
