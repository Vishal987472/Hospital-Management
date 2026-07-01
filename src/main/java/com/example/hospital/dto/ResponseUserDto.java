package com.example.hospital.dto;

import com.example.hospital.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {

    private Long id;

    private String name;

    private Role role;

}