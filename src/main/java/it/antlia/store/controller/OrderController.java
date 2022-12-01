package it.antlia.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.antlia.store.dto.OrderDto;
import it.antlia.store.model.Order;
import it.antlia.store.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private UnaBellaClasse miaClasse;

    @Autowired
    private OrderService orderService;
    
    @PostMapping("/add")
    @ResponseBody
    public void insertOrder(@RequestBody OrderDto order) {
        Order o = orderService.convert(order);
        orderService.save(o);
    }
}
