package org.mainacad.register.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by genich on 27.03.17.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Groups implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Version
    private Integer version;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    @Getter
    @Setter
    @OneToMany(mappedBy = "groups",cascade = CascadeType.ALL)
    private Set<Student> students;

}
