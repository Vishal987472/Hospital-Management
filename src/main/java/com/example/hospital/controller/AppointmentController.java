package com.example.hospital.controller;

import com.example.hospital.dto.AddAppointmentDto;
import com.example.hospital.dto.ResponseAppointmentDto;
import com.example.hospital.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService  appointmentService;

    @PreAuthorize("hasRole('RECEPTIONIST')")
    @PostMapping("")
    public ResponseEntity<String> addAppointment(@RequestBody AddAppointmentDto appointmentDto) {
        appointmentService.addAppointment(appointmentDto);

        return ResponseEntity.ok("appointment added");
    }


    @GetMapping("")
    public ResponseEntity<List<ResponseAppointmentDto>> getAllAppointments() {
        List<ResponseAppointmentDto> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok().body(appointments);
    }
}
