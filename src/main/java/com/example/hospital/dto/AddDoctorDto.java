package com.example.hospital.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddDoctorDto {
    private String name;
    private String specialization;
    private String email;
}
