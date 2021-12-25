package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@DiscriminatorValue(value = "CREATE_EVENT_FORM")
public class CreateEventForm extends Form {

   /* @JsonIgnore
    @ManyToOne()
    private ClubManager club;
    */

    public CreateEventForm(int id, LocalTime created_time, LocalDate created_date) {
        super();
    }
}
