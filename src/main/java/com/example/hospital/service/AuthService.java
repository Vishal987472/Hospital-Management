package com.example.hospital.service;

import com.example.hospital.dto.LoginDto;
import com.example.hospital.dto.ResponseLoginDto;
import com.example.hospital.dto.ResponseUserDto;
import com.example.hospital.dto.UserDto;
import com.example.hospital.entity.User;
import com.example.hospital.entity.provider.AuthProviderType;
import com.example.hospital.entity.role.Role;
import com.example.hospital.mapper.UserMapper;
import com.example.hospital.repository.UserRepository;
import com.example.hospital.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    @Lazy
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    public ResponseUserDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getName(),
                        loginDto.getPassword()
                )
        );

        org.springframework.security.core.userdetails.User securityUser =
                (org.springframework.security.core.userdetails.User)
                        authentication.getPrincipal();

        String token = jwtUtil.generateToken(securityUser.getUsername());
        User user = userRepository.findByName(securityUser.getUsername())
                .orElseThrow();

        ResponseUserDto response = userMapper.userToUserDto(user);
        response.setToken(token);
        return response;
    }

    public User signupInternal(UserDto userDto,
                               AuthProviderType providerType,
                               String providerId) {

        User existingUser = userRepository.findByName(userDto.getName()).orElse(null);

        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        User user = userMapper.toEntity(userDto);

        user.setProviderType(providerType);
        user.setProviderId(providerId);

        if (providerType == AuthProviderType.EMAIL) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        } else {
            // OAuth user → random password
            user.setPassword(passwordEncoder.encode("oauth_user"));
        }

        return userRepository.save(user);
    }
    public ResponseUserDto signup(UserDto userDto) {
        User user = signupInternal(userDto, AuthProviderType.EMAIL, null);
        return userMapper.userToUserDto(user);
    }

    @Transactional
    public ResponseEntity<ResponseLoginDto> handleOAuth2LoginRequest(
            OAuth2User oAuth2User,
            String registrationId
    ) {

        AuthProviderType providerType =
                jwtUtil.getProviderTypeFromRegistraionId(registrationId);

        String providerId =
                jwtUtil.determineProviderIdFromOAuth2User(oAuth2User, registrationId);

        String username = jwtUtil.determineUsernameFromOAuth2User(oAuth2User,registrationId,providerId);

        String email = oAuth2User.getAttribute("email");

        User user = userRepository.findByProviderIdAndProviderType(providerId,providerType)
                .orElse(null);

        User emailUser = userRepository.findByName(email).orElse(null);

        if (user == null && emailUser == null) {
            // 🆕 New user

            UserDto userDto = new UserDto();
            userDto.setName(username);
            userDto.setRole(Role.PATIENT);

            user = signupInternal(userDto, providerType, providerId);

        } else if (user != null){
            if (email != null && !email.isBlank() && !email.equals(user.getName())){
                user.setName(email);
                userRepository.save(user);
            };
        } else {
            // ❌ Same email but different provider
            throw new RuntimeException(
                    "You have already signed up using " +
                            emailUser.getProviderType() +
                            ". Please login using that provider."
            );
            // ✅ Same provider → allow
        }

        String token = jwtUtil.generateToken(user.getName());

        ResponseLoginDto response = new ResponseLoginDto(token,user.getId());


        return ResponseEntity.ok(response);
    }}
