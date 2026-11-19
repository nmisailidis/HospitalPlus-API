
package com.nmisailidis.hospitalplus_api.dto;

import com.nmisailidis.hospitalplus_api.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientUpdateRequest {

    private String amka;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String bloodGroup;
    private boolean activeStatus;

    public boolean getActiveStatus() {
        return activeStatus;
    }
}

