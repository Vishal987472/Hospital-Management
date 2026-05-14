package com.example.hospital.controller;

import com.example.hospital.dto.LoginDto;
import com.example.hospital.dto.ResponseUserDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseUserDto> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> signup(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.signup(userDto));
    }
}
