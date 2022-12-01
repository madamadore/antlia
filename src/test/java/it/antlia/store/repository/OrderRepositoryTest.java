package it.antlia.store.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import it.antlia.store.dto.OrderDto;
import it.antlia.store.model.Book;
import it.antlia.store.model.Order;
import it.antlia.store.model.Product;
import it.antlia.store.model.ProductOrder;
import it.antlia.store.model.TShirt;
import it.antlia.store.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class OrderRepositoryTest {
    
    @Autowired
    private OrderRepository repository;
    private Order order;
    
    @Before
    public void setUp() {
        Book book = new Book(1, "autore", "titolo", "publisher", 45, "ABCDE");
        TShirt tshirt = new TShirt(1, 42, "verde", "armani");
        order = new Order();
        
        ProductOrder productBook = new ProductOrder();
        productBook.setOrder(order);
        productBook.setProduct(book);
        ProductOrder productTShirt = new ProductOrder();
        productTShirt.setOrder(order);
        productTShirt.setProduct(tshirt);

        List<ProductOrder> productOrders = Arrays.asList(productTShirt, productBook);
        order.setProducts(productOrders);

        repository.deleteAll();
    }

    @After
    public void tearsDown() {
        repository.deleteAll();
    }

    @Test
    public void testSaveNewEntity() {
        assertNotEquals(
            order.getProducts().get(0).getProductOrderId(), 
            order.getProducts().get(1).getProductOrderId()
        );
        repository.save(order);

        Iterable<Order> orders = repository.findAll();
        assertTrue(orders.iterator().hasNext());

        Order order = repository.findAll().iterator().next();
        assertTrue(order.getProducts().size() == 2);
    }
}
