package com.example.hospital.mapper;

import com.example.hospital.dto.*;
import com.example.hospital.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(AddDoctorDto doctorDto);
    ResponseDoctorDto toDto(Doctor doctor);
}
