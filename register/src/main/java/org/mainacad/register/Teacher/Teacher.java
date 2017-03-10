package org.mainacad.register.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teachers")


public class Teacher {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "WorkHours")
    private String workHours;


    @Column(name = "WorkPaid")
    private String workPaid;


    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String workHours, String workPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workHours = workHours;
        this.workPaid = workPaid;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getWorkPaid() {
        return workPaid;
    }

    public void setWorkPaid(String workPaid) {
        this.workPaid = workPaid;
    }


    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (getId() != teacher.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(teacher.getFirstName()) : teacher.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(teacher.getLastName()) : teacher.getLastName() != null)
            return false;
        return true;
    }
}
