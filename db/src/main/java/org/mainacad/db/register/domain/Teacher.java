package org.mainacad.db.register.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private Integer version;
    private String firstName;
    private String lastName;
    private Double workHours;
    private Double workPaid;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Groups> groups;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Double workHours) {
        this.workHours = workHours;
    }

    public Double getWorkPaid() {
        return workPaid;
    }

    public void setWorkPaid(Double workPaid) {
        this.workPaid = workPaid;
    }

}
