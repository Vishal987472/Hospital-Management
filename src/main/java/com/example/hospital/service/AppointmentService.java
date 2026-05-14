package com.example.hospital.service;

import com.example.hospital.dto.*;
import com.example.hospital.entity.*;
import com.example.hospital.mapper.AppointmentMapper;
import com.example.hospital.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepo;
    private final AppointmentMapper mapper;
    private final DoctorRepository doctorRepo;
    private final PatientRepository patientRepo;

    public void addAppointment(AddAppointmentDto appointmentDto) {
        Doctor doc = doctorRepo.findById(appointmentDto.getDocId()).orElseThrow();
        Patient pat = patientRepo.findById(appointmentDto.getPatientId()).orElseThrow();

        // 💣 Check duplicate appointment
        boolean exists = appointmentRepo
                .existsByDoctorAndAppointmentTime(
                        doc,
                        appointmentDto.getAppointmentTime()
                );

        if (exists) {
            throw new RuntimeException(
                    "Doctor already has appointment at this time"
            );
        }

        Appointment appointment = mapper.toEntity(appointmentDto);
        appointment.setDoctor(doc);
        appointment.setPatient(pat);
        appointmentRepo.save(appointment);
    }


    public List<ResponseAppointmentDto> getAllAppointments() {
        List<ResponseAppointmentDto> appointments = appointmentRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
        return appointments;
    }
}
