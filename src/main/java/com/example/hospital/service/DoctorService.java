package com.example.hospital.service;

import com.example.hospital.dto.*;
import com.example.hospital.entity.*;
import com.example.hospital.mapper.*;
import com.example.hospital.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper mapper;

    @Transactional
    public void saveDoctor(AddDoctorDto doctorDto) {
        Doctor doctor = mapper.toEntity(doctorDto);
        doctorRepository.save(doctor);
    }

    @Transactional
    public List<ResponseDoctorDto> getDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
