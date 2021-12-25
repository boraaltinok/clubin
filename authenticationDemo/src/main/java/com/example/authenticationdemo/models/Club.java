package com.example.authenticationdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "clubs")
@Entity
public class Club {
    @Id
    int id;
    @Column(name = "club_name")
    String name;
    @Column(name = "total_member_count")
    int totalMemberCount;
    private String description;
    private String contactInfo;

    @OneToOne()
            @JoinColumn(name = "manager_id", referencedColumnName = "id")
    ClubManager clubManager;

    @ManyToMany
    @JoinTable(
        name = "student_registeredToClub",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> clubMembers = new HashSet<>();

    @OneToMany(mappedBy = "dependentClub")
    private Set<Event> clubEvents = new HashSet<>();

    public int getTotalMemberCount() {
        return totalMemberCount;
    }

    public void setTotalMemberCount(int totalMemberCount) {
        this.totalMemberCount = totalMemberCount;
    }

    public int getId() {
        return id;
    }


    public Set<Student> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(Set<Student> clubMembers) {
        this.clubMembers = clubMembers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void registerUserToClub(User user) {
        clubMembers.add(user);
        totalMemberCount = clubMembers.size();
    }*/
    public void registerStudentToClub(Student student){
        clubMembers.add(student);
        totalMemberCount = clubMembers.size();
    }
    public Set<Event> getClubEvents() {
        return clubEvents;
    }

    public void setClubEvents(Set<Event> clubEvents) {
        this.clubEvents = clubEvents;
    }
    public void addToClubEvents(Event event){
        clubEvents.add(event);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMemberCount=" + totalMemberCount +
                ", clubMembers=" + clubMembers +
                ", clubEvents=" + clubEvents +
                '}';
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
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
