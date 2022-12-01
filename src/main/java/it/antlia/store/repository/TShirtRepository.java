package it.antlia.store.repository;

import org.springframework.data.repository.CrudRepository;

import it.antlia.store.model.TShirt;

public interface TShirtRepository extends CrudRepository<TShirt, Integer> {
    
}
