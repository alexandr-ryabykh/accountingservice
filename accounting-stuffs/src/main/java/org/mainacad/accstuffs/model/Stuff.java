package org.mainacad.accstuffs.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Stuff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String paymentPurpose;
    private Double income;
    private Double outcome;
    private Double stateOfBudget;

    public Stuff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getOutcome() {
        return outcome;
    }

    public void setOutcome(Double outcome) {
        this.outcome = outcome;
    }

    public Double getStateOfBudget() {
        return stateOfBudget;
    }

    public void setStateOfBudget(Double stateOfBudget) {
        this.stateOfBudget = stateOfBudget;
    }
}



