package it.antlia.store.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;

@Entity
@Getter
@Table(name="product_order")
public class ProductOrder { 

    @EmbeddedId
    private ProductOrderId productOrderId = new ProductOrderId();

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Order order;
    @Transient
    private Product product;

    public void setOrder(Order o) {
        this.order = o;
    }

    public void setProduct(Product p) {
        this.product = p;
        this.productOrderId.setType(p.getClass().getName());
        this.productOrderId.setProductId(p.getId());
    }
}
