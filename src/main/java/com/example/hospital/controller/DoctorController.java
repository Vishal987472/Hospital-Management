package com.example.hospital.controller;

import com.example.hospital.dto.AddDoctorDto;
import com.example.hospital.dto.ResponseDoctorDto;
import com.example.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<String> addDoctor(@RequestBody AddDoctorDto doctorDto) {
        doctorService.saveDoctor(doctorDto);
        return ResponseEntity.ok("Doctor has been saved successfully");
    }


    @GetMapping("")
    public ResponseEntity<List<ResponseDoctorDto>> getAllDoctors() {
        List<ResponseDoctorDto> doctors = doctorService.getDoctors();
        return ResponseEntity.ok().body(doctors);
    }
}
