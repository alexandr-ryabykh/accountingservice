package org.mainacad.db.register.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TM_PROJECTS", schema = "accountings")
public class Project implements Serializable {

    @Id
    @Column(name = "PROJECT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    @Basic
    @NotEmpty
    @Column(name = "PROJECT_NAME", nullable = false, length = 50)
    private String projectName;

    @Basic
    @Column(name = "PROJECT_DESCRIPTION", nullable = false, length = 250)
    private String projectDescription;
}
