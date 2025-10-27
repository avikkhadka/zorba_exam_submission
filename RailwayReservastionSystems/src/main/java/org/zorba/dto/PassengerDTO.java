package org.zorba.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
    private String name;
    private String email;
    private String mobile;
    private String category;
    private String seniorCitizenId;
    private String physicalHandicapProof;
}