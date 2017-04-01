package org.mainacad.db.register.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode
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

   /* public Project() {
    }

    public Project(long projectId, String projectName, String projectDescription) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }*/
}
