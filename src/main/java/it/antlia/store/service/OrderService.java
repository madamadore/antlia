package it.antlia.store.service;

import java.io.IOException;

import it.antlia.store.dto.OrderDto;
import it.antlia.store.model.Order;

public interface OrderService {
    Order convert(OrderDto o);
    void save(Order o);
    void leggiFile() throws IOException;
}
