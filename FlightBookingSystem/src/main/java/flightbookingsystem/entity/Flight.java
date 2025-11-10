package flightbookingsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_type", nullable = false)
    private String flightType;

    @Column(name = "flight_to_address", nullable = false)
    private String flightToAddress;

    @Column(name = "flight_destination_address", nullable = false)
    private String flightDestinationAddress;

    @Column(name = "flight_duration", nullable = false)
    private String flightDuration;

    @Column(name = "flight_condition", nullable = false)
    private String flightCondition;
}
