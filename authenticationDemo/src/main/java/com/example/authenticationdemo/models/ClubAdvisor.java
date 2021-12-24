package com.example.authenticationdemo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CLUB_ADVISOR")
public class ClubAdvisor extends User{
    int advised_clubs_id;



    public ClubAdvisor() {
    }

    public ClubAdvisor(int id, String name, String surname, String password, String email, int advised_clubs_id) {
        super(id, name, surname, password, email);
        this.advised_clubs_id = advised_clubs_id;
    }

    public int getAdvised_clubs_id() {
        return advised_clubs_id;
    }

    public void setAdvised_clubs_id(int advised_clubs_id) {
        this.advised_clubs_id = advised_clubs_id;
    }

    public String giveFeedback(String feedback){
        return feedback+"";
    }
}
