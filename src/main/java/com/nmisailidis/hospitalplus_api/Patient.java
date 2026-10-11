package com.nmisailidis.hospitalplus_api;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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

    @NotBlank(message = "User must have AMKA")
    @Column(name = "national_id",unique = true, nullable = false)
    private String amka;

    @NotBlank(message = "User 's first name can not be empty")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "User 's last name should not be empty")
    @Column(nullable = false)
    private String lastName;

    @Past(message = "date of birth should be a past date")
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must contain '@' symbol")
    @Column(unique = true)
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String bloodGroup;

    private boolean activeStatus = true;
}
