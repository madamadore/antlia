package it.antlia.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ordini")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(targetEntity=ProductOrder.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "productOrderId", nullable = false, updatable = false)
    private List<ProductOrder> products = new ArrayList<>();
    private double totalAmount;

    public Order() {
        products = new ArrayList<>();
    }

    public void add(ProductOrder po) {
        products.add(po);
    }
}
