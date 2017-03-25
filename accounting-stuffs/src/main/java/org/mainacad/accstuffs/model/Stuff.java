package org.mainacad.accstuffs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Stuff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter
    @Setter
    private Date date;

    @Size(min=3, max=30, message = "Должно быть больше 3 и меньше 30")
    @Getter
    @Setter
    private String paymentPurpose;

    @Getter
    @Setter
    private Double income;

    @Getter
    @Setter
    private Double outcome;

    @Getter
    @Setter
    private Double stateOfBudget;




}



