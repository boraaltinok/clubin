package com.example.authenticationdemo.models;

import com.example.authenticationdemo.requests.CreateClubFormRequest;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "STUDENT_ACTIVITY_CENTER")
public class StudentActivityCenter extends User {

    @OneToMany(mappedBy = "studentActivityCenter")
    private Set<CreateClubForm> createClubForms = new HashSet<>();

    @OneToMany(mappedBy = "studentActivityCenter")
    private Set<CreateEventForm> createEventForms = new HashSet<>();

   // List<CreateClubFormRequest> requests;
/*
    public StudentActivityCenter(Set<CreateClubForm> createClubForms, Set<CreateEventForm> createEventForms) {
        this.createClubForms = createClubForms;
        this.createEventForms = createEventForms;
    }

    public StudentActivityCenter(int id, String name, String surname, String password, String email, Set<CreateClubForm> createClubForms, Set<CreateEventForm> createEventForms) {
        super(id, name, surname, password, email);
        this.createClubForms = createClubForms;
        this.createEventForms = createEventForms;
    }

    public StudentActivityCenter() {
    }

    public StudentActivityCenter(int id, String name, String surname, String password, String email) {
        super(id, name, surname, password, email);
    }


 */
    public Set<CreateClubForm> getCreateClubForms() {
        return createClubForms;
    }

    public void addCreateClubForm(CreateClubForm c){
        createClubForms.add(c);
    }

    public void setCreateClubForms(Set<CreateClubForm> createClubForms) {
        this.createClubForms = createClubForms;
    }

    public Set<CreateEventForm> getCreateEventForms() {
        return createEventForms;
    }

    public void setCreateEventForms(Set<CreateEventForm> createEventForms) {
        this.createEventForms = createEventForms;
    }

    public void addCreateEventForm(CreateEventForm e){
        createEventForms.add(e);
    }
/*
    public List<CreateClubFormRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<CreateClubFormRequest> requests) {
        this.requests = requests;
    }

    public void addRequest(CreateClubFormRequest request){
        requests.add(request);
    }

    public void deleteRequest(CreateClubFormRequest request){
        requests.remove(request);
    }

 */
}
