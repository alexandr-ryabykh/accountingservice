package org.mainacad.timemanager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
//import sun.plugin.util.UserProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
@Entity
@Table(name = "TM_USERS", schema = "accountings")
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Basic
    @Column(name = "lAST_NAME", nullable = false, length = 50)
    private String lastName;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TM_USERS_TM_PROJECTS",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PROJECT_ID") })
    private Set<Project> userProjects = new HashSet<>();


    public User() {
    }

    public User(long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Project> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Set<Project> userProjects) {
        this.userProjects = userProjects;
    }



}