package com.example.hospital.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class ResponseinsuranceDto {

    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDate validuntil;
}
