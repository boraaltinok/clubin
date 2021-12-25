package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String clubName = "";
    public CreateClubForm() {
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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

}
