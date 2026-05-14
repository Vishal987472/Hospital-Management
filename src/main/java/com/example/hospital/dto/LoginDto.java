package com.example.hospital.dto;

import lombok.Data;

@Data

public class LoginDto {
    private String name;
    private String password;
    private String role;
}
