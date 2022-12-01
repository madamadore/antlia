package it.antlia.store.model;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonTypeName;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="magliette")
@JsonTypeName("tshirt")
public class TShirt extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="taglia", unique = true)
    private int size;
    private String color;
    private String brand;
}
