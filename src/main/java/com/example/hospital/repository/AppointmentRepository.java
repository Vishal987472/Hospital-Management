package com.example.hospital.repository;

import com.example.hospital.entity.Appointment;
import com.example.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorAndAppointmentTime(
            Doctor doctor,
            LocalDateTime appointmentTime
    );

}