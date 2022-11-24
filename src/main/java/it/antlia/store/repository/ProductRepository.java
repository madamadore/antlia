package it.antlia.store.repository;

import java.util.ArrayList;
import java.util.List;


import it.antlia.store.model.Product;

public abstract class ProductRepository<T extends Product> {
    private List<T> magazzino = new ArrayList<>();
    
    public List<T> getList() {
        return magazzino;
    }

    public T get(int id) {
        return magazzino
                    .stream()
                    .filter(shirt->{ return shirt.getId() == id; })
                    .findFirst()
                    .orElse(null);
    }

    public void add(T product) {
        magazzino.add(product);
    }

    public void update(T product) {
        T obj = get(product.getId());
        delete(obj);
        magazzino.add(product);
    }

    public void delete(T product) {
        magazzino.remove(product);
    }
}
