package com.nmisailidis.hospitalplus_api;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AllergyCreationRequest {

    @NotBlank
    private String allergyName;




}
