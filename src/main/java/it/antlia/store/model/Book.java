package it.antlia.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="libri")
@JsonTypeName("book")
@Builder
public class Book extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
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
