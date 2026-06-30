package com.example.hospital.mapper;

import com.example.hospital.dto.*;
import com.example.hospital.entity.*;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(AddPatientDto patientDto);
    Insurance toEntity(AddInsuranceDto insurance);
    ResponsePatientDto toDto(Patient patient);
    ResponseinsuranceDto toDto(Insurance insurance);

    ResponsePatientDto toDto(Optional<Patient> patient);
}
