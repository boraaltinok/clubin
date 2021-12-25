package com.example.authenticationdemo.requests;

import com.example.authenticationdemo.models.DeanOffice;
import com.example.authenticationdemo.models.Student;
import com.example.authenticationdemo.models.StudentActivityCenter;

public class CreateClubFormRequest {
    int createClubForm_id;
    int deanOffice_id;
    int studentActivityCenter_id;
    int student_id;
    String clubName;
    int club_id;
    boolean isSuccessfull = false;
    String description;
    String contactInfo;

    public int getCreateClubForm_id() {
        return createClubForm_id;
    }

    public void setCreateClubForm_id(int createClubForm_id) {
        this.createClubForm_id = createClubForm_id;
    }

    public int getDeanOffice_id() {
        return deanOffice_id;
    }

    public void setDeanOffice_id(int deanOffice_id) {
        this.deanOffice_id = deanOffice_id;
    }

    public int getStudentActivityCenter_id() {
        return studentActivityCenter_id;
    }

    public void setStudentActivityCenter_id(int studentActivityCenter_id) {
        this.studentActivityCenter_id = studentActivityCenter_id;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
