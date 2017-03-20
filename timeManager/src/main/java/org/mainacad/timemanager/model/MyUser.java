package org.mainacad.timemanager.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tmusers", schema = "accountings")
public class MyUser implements Serializable {

    @Id
    @Column(name = "myuserid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myUserId;

    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstName;

    public MyUser() {
    }

    public MyUser(String firstName) {
        this.firstName = firstName;
    }

    public long getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(long myUserId) {
        this.myUserId = myUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUser = (MyUser) o;

        if (getMyUserId() != myUser.getMyUserId()) return false;
        if (!getFirstName().equals(myUser.getFirstName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (getMyUserId() ^ (getMyUserId() >>> 32));
        result = 31 * result + getFirstName().hashCode();
        return result;
    }
}