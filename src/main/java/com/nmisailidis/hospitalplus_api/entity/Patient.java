package com.nmisailidis.hospitalplus_api.entity;

import com.nmisailidis.hospitalplus_api.enums.BloodGroup;
import com.nmisailidis.hospitalplus_api.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(unique = true, nullable = false)
    private String amka;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth;
    private Gender gender;
    private String phoneNumber;

    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private boolean activeStatus = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public boolean getActiveStatus() {
        return activeStatus;
    }

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
