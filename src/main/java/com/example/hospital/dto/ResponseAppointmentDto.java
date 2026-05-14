package com.example.hospital.dto;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ResponseAppointmentDto {

    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private Long doctorId;
    private String doctorName;
    private Long patientId;
    private String patientName;
}
