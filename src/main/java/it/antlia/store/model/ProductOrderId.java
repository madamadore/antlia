package it.antlia.store.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class ProductOrderId implements Serializable {
        @Column(nullable = false, insertable = false, updatable = false)
        private int orderId;
        @Column(nullable = false, insertable = false, updatable = false)
        private int productId;
        @Column(nullable = false, insertable = false, updatable = false)
        private String type;
}
