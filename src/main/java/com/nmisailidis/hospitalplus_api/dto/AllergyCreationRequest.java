package com.nmisailidis.hospitalplus_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AllergyCreationRequest {

    @NotBlank
    private String allergyName;




}
