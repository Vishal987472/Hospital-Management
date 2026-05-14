package com.example.hospital.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ResponseDoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private LocalDateTime createdAt;
}
