package it.antlia.store.repository;
import org.springframework.data.repository.CrudRepository;
import it.antlia.store.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    
}
