package com.example.authenticationdemo.dto;

import com.example.authenticationdemo.models.Club;

public class ClubJoinRequest {
    private Club club;

    @Override
    public String toString() {
        return "ClubJoinRequest{" +
                "club=" + club +
                '}';
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
