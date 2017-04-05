package org.mainacad.db.register.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

//@Data
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "TM_DAYTIME", schema = "accountings")
public class DayTime implements Serializable {

    @Id
    @Column(name = "DAYTIME_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dayTimeId;

    @Basic
    //@NotEmpty
    //@Max(24)
    @Column(name = "HOURS_PER_DAY", nullable = false)
    private double hoursPerDay;

    @Basic
    //@NotEmpty
    //@Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE", nullable = false)
    private Date date;

    /*@Basic
    //@NotEmpty
    @Column(name = "USER_ID", nullable = false)
    private long userId;*/

    @Getter
    @Setter
    @JoinColumn
    @ManyToOne(optional = false)
    private UserTM users;


    @ManyToOne
    @JoinColumn
    private Project projects;

    public DayTime() {
    }

    public DayTime(long dayTimeId, double hoursPerDay, Date date, UserTM users, Project projects) {
        this.dayTimeId = dayTimeId;
        this.hoursPerDay = hoursPerDay;
        this.date = date;
        this.users = users;
        this.projects = projects;
    }

    public long getDayTimeId() {
        return dayTimeId;
    }

    public void setDayTimeId(long dayTimeId) {
        this.dayTimeId = dayTimeId;
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(double hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }





    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }



    public UserTM getUserTMs() {
        return users;
    }

    public void setUserTMs(UserTM users) {
        this.users = users;
    }
}
