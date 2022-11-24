package it.antlia.store.model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
public class TShirt extends Product {
    private int size;
    private String color;
    private String brand;
}
