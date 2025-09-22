package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "Product_Type") // matches your table name
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_type_id")
    private Integer prodTypeId;

    @Column(name = "product_type", length = 100)
    private String productType;

    @Column(name = "rate", precision = 10, scale = 2)
    private BigDecimal rate;

    // Default constructor
    public ProductCategory() {}

    // Parameterized constructor
    public ProductCategory(String productType, BigDecimal rate) {
        this.productType = productType;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ProductCategory [prodTypeId=" + prodTypeId + ", productType=" + productType + ", rate=" + rate + "]";
    }
}
