package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "FORM_TYPE",
        discriminatorType = DiscriminatorType.STRING
)//one additional column discriminator column
@Table (name = "form")
public abstract class Form {
    @Id
    private int id;
    private String created_time;
    private String created_date;

    @JsonIgnore
    @ManyToOne
            @JoinColumn(name = "sac_id")
    StudentActivityCenter studentActivityCenter;

    @JsonIgnore
    @ManyToOne
        @JoinColumn(name = "dean_id")
    DeanOffice deanOffice;

    public Form() {
        created_time = LocalTime.now() + " ";
        created_date = LocalDate.now() + " ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public StudentActivityCenter getStudentActivityCenter() {
        return studentActivityCenter;
    }

    public void setStudentActivityCenter(StudentActivityCenter studentActivityCenter) {
        this.studentActivityCenter = studentActivityCenter;
    }

    public DeanOffice getDeanOffice() {
        return deanOffice;
    }

    public void setDeanOffice(DeanOffice deanOffice) {
        this.deanOffice = deanOffice;
    }
}
