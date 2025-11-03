package flightbookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    private String passengerName;
    private String passengerEmail;
    private String passengerMobile;
    private String passengerAddress;
}
