package it.antlia.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.antlia.store.dto.OrderDto;
import it.antlia.store.model.Order;
import it.antlia.store.model.TShirt;
import it.antlia.store.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier("armani")
    private TShirt tshirtArmani;
    
    @PostMapping("/add")
    @ResponseBody
    public void insertOrder(@RequestBody OrderDto order) {
        Order o = orderService.convert(order);
        orderService.save(o);
    }
}
