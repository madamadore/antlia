package it.antlia.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import it.antlia.store.dto.OrderDto;
import it.antlia.store.model.Book;
import it.antlia.store.model.Order;
import it.antlia.store.model.Product;
import it.antlia.store.model.TShirt;
import it.antlia.store.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes= { OrderServiceImpl.class })
public class OrderServiceTest {
    
    @MockBean
    OrderRepository orderRepository;
    
    @Autowired
    private OrderService orderService;
    private OrderDto oo;

    @Before
    public void setUp() {
        List<Product> products = new ArrayList<>();
        products.add(new Book(1, "autore", "titolo", "publisher", 45, "ABCDE"));
        products.add(new TShirt(1, 42, "verde", "armani"));
        oo = new OrderDto();
        oo.setProducts(products);
    }

    @Test
    public void testConvert() {
        Order order = orderService.convert(oo);
        assertEquals(2, order.getProducts().size());
        assertEquals(Book.class.getName(), order.getProducts()
                                                    .get(0)
                                                    .getProductOrderId()
                                                    .getType());
        assertEquals(TShirt.class.getName(), order.getProducts()
                                                    .get(1)
                                                    .getProductOrderId()
                                                    .getType());
    }
}
