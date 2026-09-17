
package com.nmisailidis.hospitalplus_api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientUpdateRequest {

    private Long national_id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String bloodGroup;

}

