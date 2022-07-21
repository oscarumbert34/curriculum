package com.curriculum.vitae.facade;

import com.curriculum.vitae.dtos.CurriculumDTO;
import com.curriculum.vitae.services.EducationService;
import com.curriculum.vitae.services.PersonalInformationService;
import com.curriculum.vitae.services.SkillService;
import com.curriculum.vitae.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumVitaeFacade {

    private PersonalInformationService personalInformationService;
    private WorkExperienceService workExperienceService;
    private SkillService skillService;
    private EducationService educationService;

    @Autowired
    public CurriculumVitaeFacade(PersonalInformationService personalInformationService,
                                 WorkExperienceService workExperienceService,
                                 SkillService skillService,
                                 EducationService educationService){
        this.personalInformationService = personalInformationService;
        this.workExperienceService = workExperienceService;
        this.skillService = skillService;
        this.educationService = educationService;
    }

    public CurriculumDTO getAll(String documentNumber){

        return CurriculumDTO.builder().education(this.educationService.findAll())
                    .personalInformation(this.personalInformationService.findByDocumentNumber(documentNumber))
                    .workExperience(this.workExperienceService.findAll())
                    .skills(this.skillService.findAll()).build();
    }
}
