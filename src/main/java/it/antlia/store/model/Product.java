package it.antlia.store.model;

import lombok.Getter;

@Getter
public abstract class Product {

    private static int staticID = 0;

    private int id;

    Product() {
        this.id = ++staticID;
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
