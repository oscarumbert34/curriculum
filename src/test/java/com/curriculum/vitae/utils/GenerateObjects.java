package com.curriculum.vitae.utils;

import com.curriculum.vitae.dtos.WorkExperienceDTO;

import java.time.LocalDate;

public class GenerateObjects {

    protected static WorkExperienceDTO createDto() {
        return WorkExperienceDTO.builder().description("dfsdf").business("T4T")
                .endDate(LocalDate.now()).job("Desarrollador Java").state("ACTUALLY")
                .initDate(LocalDate.now()).build();
    }
}
