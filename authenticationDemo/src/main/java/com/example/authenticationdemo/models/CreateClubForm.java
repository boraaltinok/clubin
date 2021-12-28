package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue(value = "CREATE_CLUB_FORM")
public class CreateClubForm extends  Form {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student creatorStudent;
    private boolean isSuccesfull = false;
    private boolean isPassedFromSac = false;
    private int saCenter_id;
    private int deanOffice_id;
    private int club_id;
    private int capacity;
    private int budget;
    private int event_id;
    private int ge_point;
    private boolean isOnline;
    private int s_id;
    private String clubName = "";
    public CreateClubForm() {
        super();
        capacity = 0;
        budget =0;
        event_id = 0;
        ge_point =0;
        isOnline = false;
    }

    public int getStudent_id() {
        return s_id;
    }

    public void setStudent_id(int student_id) {
        this.s_id = student_id;
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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getSac_id() {
        return saCenter_id;
    }

    public void setSac_id(int sac_id) {
        this.saCenter_id = sac_id;
    }

    public int getDean_id() {
        return deanOffice_id;
    }

    public void setDean_id(int dean_id) {
        this.deanOffice_id = dean_id;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }
}
