package com.nmisailidis.hospitalplus_api;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(unique = true, nullable = false)
    private String nationalId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;

    @Column(unique = true)
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String bloodGroup;

    private boolean activeStatus = true;
}
