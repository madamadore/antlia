package it.antlia.store.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getList();
    T get(int id);
    void add(T object);
    void update(T object);
    void delete(T object);
}
