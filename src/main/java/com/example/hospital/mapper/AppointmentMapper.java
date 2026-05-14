package com.example.hospital.mapper;

import com.example.hospital.dto.AddAppointmentDto;
import com.example.hospital.dto.ResponseAppointmentDto;
import com.example.hospital.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "doctorName", source = "doctor.name")
    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "patientName", source = "patient.name")
    ResponseAppointmentDto toDto(Appointment appointment);

    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Appointment toEntity(AddAppointmentDto appointmentDto);
}

