package org.mainacad.timemanager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

//@Data
//@EqualsAndHashCode
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

    @Basic
    //@NotEmpty
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    @Basic
    //@NotEmpty
    @Column(name = "PROJECT_ID", nullable = false)
    private long projectId;

    public DayTime() {
    }

    public DayTime(long dayTimeId, double hoursPerDay, Date date, long userId, long projectId) {
        this.dayTimeId = dayTimeId;
        this.hoursPerDay = hoursPerDay;
        this.date = date;
        this.userId = userId;
        this.projectId = projectId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
