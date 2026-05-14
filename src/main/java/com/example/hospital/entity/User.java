package com.example.hospital.entity;

import com.example.hospital.entity.provider.AuthProviderType;
import com.example.hospital.entity.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "user_table",
        indexes ={
                @Index(name = "idx_provider_id_provider_type", columnList = "providerId, providerType")
        }
)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String providerId;

    @Enumerated(EnumType.STRING)
    private AuthProviderType  providerType;

    @Enumerated(EnumType.STRING)
    private Role role;

}
