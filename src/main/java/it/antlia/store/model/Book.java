package it.antlia.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book extends Product {
    private String author;
    private String title;
    private String publisher;
    private int numberOfPages;
    private String ibnCode;

    

    @Override
    public String toString() {
        return new StringBuilder()
                    .append(author)
                    .append(", ")
                    .append(title)
                    .append(": ")
                    .append(ibnCode)
                    .toString();
    }
}
