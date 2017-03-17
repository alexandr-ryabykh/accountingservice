package org.mainacad.accGoods.model;




import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Stuff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String nameOfStuff;
    private Integer quantityOfStuff;
    private Integer priceOfStuff;


    public Stuff() {

    }

    public Stuff(String nameOfStuff, Integer quantityOfStuff, Integer priceOfStuff) {
        this.nameOfStuff = nameOfStuff;
        this.quantityOfStuff = quantityOfStuff;
        this.priceOfStuff = priceOfStuff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfStuff() {
        return nameOfStuff;
    }

    public void setNameOfStuff(String nameOfStuff) {
        this.nameOfStuff = nameOfStuff;
    }

    public Integer getQuantityOfStuff() {
        return quantityOfStuff;
    }

    public void setQuantityOfStuff(Integer quantityOfStuff) {
        this.quantityOfStuff = quantityOfStuff;
    }

    public Integer getPriceOfStuff() {
        return priceOfStuff;
    }

    public void setPriceOfStuff(Integer priceOfStuff) {
        this.priceOfStuff = priceOfStuff;
    }
}