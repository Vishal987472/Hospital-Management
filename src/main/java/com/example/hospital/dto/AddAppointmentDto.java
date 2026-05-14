package com.example.hospital.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@Getter
@Setter
public class AddAppointmentDto {

    private LocalDateTime appointmentTime;

    private String reason;

    private Long patientId;

    private Long docId;
}
