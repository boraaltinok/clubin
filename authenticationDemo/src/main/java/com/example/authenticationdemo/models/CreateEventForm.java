package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue(value = "CREATE_EVENT_FORM")
public class CreateEventForm extends Form {

   /* @JsonIgnore
    @ManyToOne()
    private ClubManager club;
    */

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ClubManager clubManager;
    private boolean isSuccesfull = false;
    private boolean isPassedFromSac = false;
    private int capacity;
    private String eventName;
    private String description;
    private String location;
    private String endDate;
    private String scheduledTime;
    private int deanOffice_id;
    private int saCenter_id;
    private int club_id;
    private int event_id;
    private int budget;
    private int ge_point;
    private boolean isOnline;

    public CreateEventForm() {
        super();
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    public int getDeanOffice_id() {
        return deanOffice_id;
    }

    public void setDeanOffice_id(int deanOffice_id) {
        this.deanOffice_id = deanOffice_id;
    }

    public int getSaCenter_id() {
        return saCenter_id;
    }

    public void setSaCenter_id(int saCenter_id) {
        this.saCenter_id = saCenter_id;
    }

    public boolean isSuccesfull() {
        return isSuccesfull;
    }

    public void setSuccesfull(boolean succesfull) {
        isSuccesfull = succesfull;
    }

    public boolean isPassedFromSac() {
        return isPassedFromSac;
    }

    public void setPassedFromSac(boolean passedFromSac) {
        isPassedFromSac = passedFromSac;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDean_id() {
        return deanOffice_id;
    }

    public void setDean_id(int dean_id) {
        this.deanOffice_id = dean_id;
    }

    public int getSac_id() {
        return saCenter_id;
    }

    public void setSac_id(int sac_id) {
        this.saCenter_id = sac_id;
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

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getGe_point() {
        return ge_point;
    }

    public void setGe_point(int ge_point) {
        this.ge_point = ge_point;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }


}
