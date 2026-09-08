package com.nmisailidis.hospitalplus_api;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChronicDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chronicDiseaseId;

    private String chronicDiseaseName;

    @ManyToOne
    private Patient patient;
}
