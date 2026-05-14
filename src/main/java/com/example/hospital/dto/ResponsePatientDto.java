package com.example.hospital.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ResponsePatientDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String bloodGroup;
    private LocalDateTime createdAt;
    private ResponseinsuranceDto insurance;

}
