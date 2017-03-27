package org.mainacad.register.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teacher",schema = "accountings")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEACHERID")
    private Long id;

    @Version
    private Integer version;
    @Basic
    @Column
    private String firstName;
    @Basic
    @Column
    private String lastName;
    @Basic
    @Column
    private Double workHours;
    @Basic
    @Column
    private Double workPaid;
    @OneToMany(mappedBy = "teacher")
    private Set<Grouppy> grouppies;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Teacher))
            return false;
        Teacher other = (Teacher) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }

    public Set<Grouppy> getGrouppies() {
        return grouppies;
    }

    public void setGrouppies(Set<Grouppy> grouppies) {
        this.grouppies = grouppies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
