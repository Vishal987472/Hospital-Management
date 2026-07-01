package com.example.hospital.controller;

import com.example.hospital.dto.LoginDto;
import com.example.hospital.dto.ResponseUserDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.security.CookieUtil;
import com.example.hospital.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CookieUtil cookieUtil;


    @PostMapping("/login")
    public ResponseEntity<ResponseUserDto> login(
            @RequestBody LoginDto dto,
            HttpServletResponse response
    ){
        return ResponseEntity.ok(
                authService.login(dto,response)
        );
    }
    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> signup(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.signup(userDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {

        cookieUtil.clear(response);

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseUserDto> me(Authentication authentication) {
        return ResponseEntity.ok(
                authService.getCurrentUser(authentication)
        );
    }
}
