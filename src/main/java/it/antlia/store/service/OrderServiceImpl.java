package it.antlia.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.antlia.store.model.Book;
import it.antlia.store.model.Order;
import it.antlia.store.model.Product;
import it.antlia.store.model.ProductOrder;
import it.antlia.store.dto.OrderDto;
import it.antlia.store.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repo;

    @Override
    public Order convert(OrderDto dto) {
        Order order = new Order();
        for (Product p : dto.getProducts()) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setOrder(order);
            productOrder.setProduct(p);
            order.add(productOrder);
        }
        return order;
    }

    @Override
    public void save(Order o) {
        repo.save(o);
    }
}
