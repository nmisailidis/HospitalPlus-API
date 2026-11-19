package com.nmisailidis.hospitalplus_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("M"), FEMALE("F");

    private String code;

}
