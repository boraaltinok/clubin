package com.example.authenticationdemo.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "clubs")
@Entity
public class Club {
    @Id
    int id;
    @Column(name = "club_name")
    String name;
    @Column(name = "total_member_count")
    int totalMemberCount;

    public int getTotalMemberCount() {
        return totalMemberCount;
    }

    public void setTotalMemberCount(int totalMemberCount) {
        this.totalMemberCount = totalMemberCount;
    }

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
            @JoinColumn(  name = "user_id", referencedColumnName = "id")
    List<User> clubMembers;
    public int getId() {
        return id;
    }

    public List<User> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(List<User> clubMembers) {
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
}
