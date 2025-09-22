package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "ProductId", length = 50)
    private String productId;

    @Column(name = "ProductName", length = 100)
    private String productName;

    @Column(name = "productQuantity", precision = 10, scale = 2)
    private BigDecimal productQuantity;

    @ManyToOne
    @JoinColumn(name = "prod_type_id", nullable = false)
    private ProductCategory category;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(String productId, String productName, BigDecimal productQuantity, ProductCategory category) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName +
                ", productQuantity=" + productQuantity + ", category=" + category.getProductType() + "]";
    }
}
