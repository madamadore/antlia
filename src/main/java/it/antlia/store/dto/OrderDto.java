package it.antlia.store.dto;

import java.util.List;
import it.antlia.store.model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto {
    private int id;
    private int userId;
    private List<Product> products;
}
