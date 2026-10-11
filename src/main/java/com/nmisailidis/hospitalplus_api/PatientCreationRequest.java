package com.nmisailidis.hospitalplus_api;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PatientCreationRequest {

    @NotBlank(message = "User must have AMKA")
    private String amka;

    @NotBlank(message = "User 's first name can not be empty")
    private String firstName;

    @NotBlank(message = "User 's last name should not be empty")
    private String lastName;

    @Past(message = "date of birth should be a past date")
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must contain '@' symbol")
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String bloodGroup;
}
