package it.antlia.store.model;

import lombok.Getter;

@Getter
public abstract class Product {

    private static int staticID = 0;

    private int id;

    Product() {
        this.id = ++staticID;
    }
}
