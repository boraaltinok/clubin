package com.example.authenticationdemo.requests;

public class EventCreateRequest {
    int id;
    int club_id;
    String location;


    public EventCreateRequest() {
    }

    public EventCreateRequest(int id, int club_id) {
        this.id = id;
        this.club_id = club_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }
}
