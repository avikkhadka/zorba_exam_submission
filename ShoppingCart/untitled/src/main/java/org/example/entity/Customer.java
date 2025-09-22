package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "custId", length = 50)
    private String custId;

    @Column(name = "custName", length = 100)
    private String custName;

    @Column(name = "custEmail", length = 100)
    private String custEmail;

    @Column(name = "custMobile")
    @Digits(integer = 10, fraction = 0, message = "Mobile number must be exactly 10 digits")
    private Long custMobile;

    @Column(name = "finalProductPrice", precision = 10, scale = 2)
    private BigDecimal finalProductPrice;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(String custId, String custName, String custEmail, Long custMobile, BigDecimal finalProductPrice) {
        this.custId = custId;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custMobile = custMobile;
        this.finalProductPrice = finalProductPrice;
    }

    @Override
    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName +
                ", custEmail=" + custEmail + ", custMobile=" + custMobile +
                ", finalProductPrice=" + finalProductPrice + "]";
    }
}
