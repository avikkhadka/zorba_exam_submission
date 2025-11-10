package flightbookingsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "passenger_email", nullable = false, unique = true)
    private String passengerEmail;

    @Column(name = "passenger_mobile", nullable = false, unique = true)
    private String passengerMobile;

    @Column(name = "passenger_address", nullable = false)
    private String passengerAddress;


    @Column(name = "passenger_username", nullable = false, unique = true)
    private String passengerUsername;

    @Column(name = "passenger_password", nullable = false)
    private String passengerPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "passenger_roles",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
