package com.example.hospital.service;

import com.example.hospital.dto.AddPatientDto;
import com.example.hospital.dto.ResponsePatientDto;
import com.example.hospital.entity.Insurance;
import com.example.hospital.entity.Patient;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Transactional
    public void savePatient(AddPatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        // 🔥 Convert insurance DTO → entity
        if (patientDto.getInsurance() != null) {

            Insurance insurance =
                    patientMapper.toEntity(patientDto.getInsurance());

            // 🔥 connect relationship
            patient.setInsurance(insurance);
            insurance.setPatient(patient); // recommended
        }
        patientRepository.save(patient);
    }


    public List<ResponsePatientDto> getPatients() {
        List<ResponsePatientDto> patientDto = patientRepository.findAll()
                .stream()
                .map(patientMapper::toDto)
                .toList();
        return patientDto;
    }

    @Transactional
    public void removeInsurance(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        patient.setInsurance(null);
    }

    public ResponsePatientDto getPatient(String username) {
        Patient patient = patientRepository.findByName(username);
        return patientMapper.toDto(patient);
    }

    @Transactional
    public ResponsePatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findByUId(id);
        return patientMapper.toDto(patient);
    }
}
