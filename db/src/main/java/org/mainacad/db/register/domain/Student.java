package org.mainacad.db.register.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private Integer version;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String eMail;

    @ManyToOne
    @JoinColumn
    private Groups groups;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Payments> payments;
}
