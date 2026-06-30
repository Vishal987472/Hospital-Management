package com.example.hospital.controller;


import com.example.hospital.dto.AddPatientDto;
import com.example.hospital.dto.ResponsePatientDto;
import com.example.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;


    @PreAuthorize("hasRole('RECEPTIONIST')")
    @PostMapping("")
    public ResponseEntity<String> addPatient(@RequestBody AddPatientDto patientDto){
        patientService.savePatient(patientDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<ResponsePatientDto>> getAllPatients(){
        List<ResponsePatientDto> patients = patientService.getPatients();

        return ResponseEntity.ok().body(patients);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<ResponsePatientDto> getPatientById(@PathVariable Long id){
        ResponsePatientDto patient = patientService.getPatientById(id);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping("username/{username}")
    @PreAuthorize("hasRole('PATIENT') and #username == authentication.name")
    public ResponseEntity<ResponsePatientDto> getPatientById(@PathVariable String username){
        ResponsePatientDto patient = patientService.getPatient(username);
        return ResponseEntity.ok().body(patient);
    }

    @PreAuthorize("hasRole('RECEPTIONIST')")
    @DeleteMapping("/{id}/insurance")
    public ResponseEntity<String> removeInsurance(@PathVariable Long id){
        patientService.removeInsurance(id);

        return ResponseEntity.ok("Insurance removed");
    }
}
