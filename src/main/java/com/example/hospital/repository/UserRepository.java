package com.example.hospital.repository;

import com.example.hospital.entity.User;
import com.example.hospital.entity.provider.AuthProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByProviderIdAndProviderType(String providerId, AuthProviderType providerType);
}