package com.example.authenticationdemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AllClubs {
    @Id
    int club_id;
    @Column(name = "club_name")
    String club_name;

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public String getClub_name() {
        return club_name;
    }

    @Override
    public String toString() {
        return "AllClubs{" +
                "club_id=" + club_id +
                ", club_name='" + club_name + '\'' +
                '}';
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }
}
