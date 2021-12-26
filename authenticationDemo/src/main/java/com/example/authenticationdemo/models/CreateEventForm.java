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
    private Student creatorStudent;
    private boolean isSuccesfull = false;
    private boolean isPassedFromSac = false;
    private String eventType;
    private String location;
    private String date;
    private String time;

    public CreateEventForm(int id, LocalTime created_time, LocalDate created_date) {
        super();
    }

    public Student getCreatorStudent() {
        return creatorStudent;
    }

    public void setCreatorStudent(Student creatorStudent) {
        this.creatorStudent = creatorStudent;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
