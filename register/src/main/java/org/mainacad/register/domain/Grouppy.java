package org.mainacad.register.domain;

import org.mainacad.students.model.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by genich on 27.03.17.
 */
@Entity
@Table(name = "grouppy",schema = "accountings")
public class Grouppy implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUPID")
    private Long id;

    @Version
    private Integer version;
    private String name;
    @ManyToOne
    @JoinColumn(name="TEACHERID")
    private Teacher teacher;
    @OneToMany(mappedBy = "grouppy")
    private Set<Student> students;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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
        if (!(obj instanceof Grouppy))
            return false;
        Grouppy other = (Grouppy)obj;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

