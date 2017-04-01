package org.mainacad.db.register.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TM_USERS", schema = "accountings")
public class UserTM implements Serializable {

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
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID")})
    private Set<Project> userProjects = new HashSet<>();


    public UserTM() {
    }

    public UserTM(long userId, String firstName, String lastName) {
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