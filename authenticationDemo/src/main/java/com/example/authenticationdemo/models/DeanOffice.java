package com.example.authenticationdemo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "DEAN_OFFICE")
public class DeanOffice extends User{

    @OneToMany(mappedBy = "deanOffice")
    private Set<CreateClubForm> createClubForms = new HashSet<>();

    @OneToMany(mappedBy = "deanOffice")
    private Set<CreateEventForm> createEventForms = new HashSet<>();
    public DeanOffice() {
    }


    public DeanOffice(int id, String name, String surname, String password, String email) {
        super(id, name, surname, password, email);
    }

    public Set<CreateClubForm> getCreateClubForms() {
        return createClubForms;
    }

    public void setCreateClubForms(Set<CreateClubForm> createClubForms) {
        for (CreateClubForm form: createClubForms
             ) {
            if(form.isPassedFromSac()){
                addCreateClubForms(form);
            }
        }
    }

    public void addCreateClubForms(CreateClubForm form){
        if(form.isPassedFromSac()){
            createClubForms.add(form);
        }
    }

    public void deleteCreateClubForm(CreateClubForm form){
        createClubForms.remove(form);
    }

    public void addCreateEventForm(CreateEventForm form){
        createEventForms.add(form);
    }
    public void deleteCreateEventForm(CreateEventForm form){
        createEventForms.remove(form);
    }

    public Set<CreateEventForm> getCreateEventForms() {
        return createEventForms;
    }

    public void setCreateEventForms(Set<CreateEventForm> createEventForms) {
        this.createEventForms = createEventForms;
    }
}
