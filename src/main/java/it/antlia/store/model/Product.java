package it.antlia.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, 
      include = As.PROPERTY, property = "type") @JsonSubTypes({
      
      @JsonSubTypes.Type(value = TShirt.class, name = "tshirt"),
      @JsonSubTypes.Type(value = Book.class, name = "book")
   })
public abstract class Product {

    private static int staticID = 0;
    @Id
    private int id;
    private double price;

    Product() {
        this.id = ++staticID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return id == ((Product) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
