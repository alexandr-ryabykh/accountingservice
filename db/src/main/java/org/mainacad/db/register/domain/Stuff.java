package org.mainacad.db.register.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Stuff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @Size(min = 3, max = 30, message = "Должно быть больше 3 и меньше 30")
    private String paymentPurpose;


    private double income;

    private double outcome;

    private double stateOfBudget;

}



