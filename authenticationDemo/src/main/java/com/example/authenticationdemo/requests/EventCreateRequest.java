package com.example.authenticationdemo.requests;

public class EventCreateRequest {
    int id;
    int club_id;
    int form_id;
    String location;
    String date;
    String endDate;
    boolean isOnline;
    int capacity;
    int sac_id;
    int dean_id;
    String eventName;
    String description;
    int event_id;
    int ge_point;
    Integer budget;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSac_id() {
        return sac_id;
    }

    public void setSac_id(int sac_id) {
        this.sac_id = sac_id;
    }

    public int getDean_id() {
        return dean_id;
    }

    public void setDean_id(int dean_id) {
        this.dean_id = dean_id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getGe_point() {
        return ge_point;
    }

    public void setGe_point(int ge_point) {
        this.ge_point = ge_point;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }


}
