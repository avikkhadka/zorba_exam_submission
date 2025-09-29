package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@DiscriminatorValue("senior")
public class SeniorCitizenPassenger extends Passenger{

    @Column(name="discount")
    private boolean discount;

    @Column(name="senior_citizen_id")
    private String seniorCitizenId;

}
