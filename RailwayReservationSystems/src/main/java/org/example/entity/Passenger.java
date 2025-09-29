package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@ToString
@Entity
@Table(name="passengers")
@DiscriminatorColumn(name = "passenger_type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="passenger_id")
    private Long passengerId;

    @Column(name="passenger_name")
    private String name;

    @Column(name="passenger_email")
    private String email;

    @Column(name="passenger_mobile")
    private String mobile;

    @Column(name="passenger_destination")
    private String destination;

    @Column(name="passenger_seat_number")
    private String seatNumber;


}
