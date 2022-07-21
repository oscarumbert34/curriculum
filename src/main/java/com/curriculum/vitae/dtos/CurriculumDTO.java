package com.curriculum.vitae.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CurriculumDTO {
    private PersonalInformationDTO personalInformation;
    private List<WorkExperienceDTO> workExperience;
    private List<EducationDTO> education;
    private List<SkillDTO> skills;


}
