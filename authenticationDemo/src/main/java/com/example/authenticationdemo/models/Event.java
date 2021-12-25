package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    int id;
    String name;
    Date date;
    LocalTime startingTime;
    LocalTime endingTime;
    int gePoint;
    int capacity;
    boolean isPassed;
    boolean isOnline;
    int budget;

    public Event(int id, String name, Date date, LocalTime startingTime,
                 LocalTime endingTime, int gePoint, int capacity, boolean isPassed, boolean isOnline,
                 int budget, Club dependentClub, Set<Student> registeredStudents,
                 SpecificEventNotification specificEventNotification) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.gePoint = gePoint;
        this.capacity = capacity;
        this.isPassed = isPassed;
        this.isOnline = isOnline;
        this.budget = budget;
        this.dependentClub = dependentClub;
        this.registeredStudents = registeredStudents;
        this.specificEventNotification = specificEventNotification;
    }

    public Event() {

    }



    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id")
    private Club dependentClub;

    @ManyToMany
    @JoinTable(
            name = "student_registeredToEvent",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> registeredStudents = new HashSet<>();


    @OneToOne
    @JoinColumn(name = "notification_id")
    private SpecificEventNotification specificEventNotification;

    public SpecificEventNotification getSpecificEventNotification() {
        return specificEventNotification;
    }

    public void setSpecificEventNotification(SpecificEventNotification specificEventNotification) {
        this.specificEventNotification = specificEventNotification;
    }




    public Set<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Set<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", dependentClub=" + dependentClub +
                '}';
    }

    public Club getDependentClub() {
        return dependentClub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDependentClub(Club dependentClub) {
        this.dependentClub = dependentClub;
    }

    public void assignClub(Club club) {
        this.dependentClub = dependentClub;//assigning the event to club
    }

    public void registerStudentToEvent(Student student){
        registeredStudents.add(student);
    }

    public boolean updateNotificationVisibility(){
        if(date.getTime() - System.currentTimeMillis() < 86400000){
            specificEventNotification.setVisibility(true);
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public int getGePoint() {
        return gePoint;
    }

    public void setGePoint(int gePoint) {
        this.gePoint = gePoint;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
