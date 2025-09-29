package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("general")
public class GeneralPassenger extends Passenger {

   @Column(name="coach_type")
    private String coachType;

    @Override
    public String toString() {
        return "GeneralPassenger{" +
                "Passenger Name: "+super.getName()+", "+
                "coachType='" + coachType + '\'' +
                '}';
    }
}
