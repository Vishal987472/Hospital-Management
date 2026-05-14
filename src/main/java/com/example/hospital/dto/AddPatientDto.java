package com.example.hospital.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class AddPatientDto {

    private String name;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String bloodGroup;
    private AddInsuranceDto insurance;

}
