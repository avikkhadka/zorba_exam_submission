package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("phy_handicapped")

public class PhysicallyHandicappedPassenger extends Passenger {
@Column(name="proof_of_disability")
private String proofOfDisability;

    @Override
    public String toString() {
        return "PhysicallyHandicappedPassenger{" +
                "Passenger Name: " + super.getName() + ", " +
                "proofOfDisability='" + proofOfDisability + '\'' +
                '}';
    }

}
