package com.curriculum.vitae.mappers;

import com.curriculum.vitae.dtos.EducationDTO;
import com.curriculum.vitae.dtos.PersonalInformationDTO;
import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.models.*;
import org.modelmapper.ModelMapper;

import com.curriculum.vitae.dtos.WorkExperienceDTO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mapper {

	private static ModelMapper modelMapper = new ModelMapper();

	public static WorkExperience mapWorkExperienceDTOtoWorkExperience(WorkExperienceDTO workExperienceDTO) {
		WorkExperience workExperience = modelMapper.map(workExperienceDTO, WorkExperience.class);
		workExperience.setState(State.valueOf(workExperienceDTO.getState()));
		return workExperience;
	}

	public static WorkExperienceDTO mapWorkExperienceToWorkExperienceDTO(WorkExperience workExperience) {
		return modelMapper.map(workExperience, WorkExperienceDTO.class);
	}

	public static List<WorkExperienceDTO> mapWorkExperiencesToWorkExperiencesDTO(List<WorkExperience> workExperiences) {
		return workExperiences.stream().map(Mapper::mapWorkExperienceToWorkExperienceDTO)
				.collect(Collectors.toList());
	}

	public static Education mapEducationDTOToEducation(EducationDTO educationDTO){
		Education education = modelMapper.map(educationDTO, Education.class);
		education.setState(State.valueOf(educationDTO.getState()));
		return education;
	}

	public static EducationDTO mapEducationToEducationDTO(Education education){
		return modelMapper.map(education, EducationDTO.class);
	}

	public static List<EducationDTO> mapEducationsToEducationDTOs(List<Education> educations){
		return educations.stream().map(Mapper::mapEducationToEducationDTO).collect(Collectors.toList());
	}

	public static Skill mapSkillDTOtoSkill(SkillDTO skillDTO){
		return modelMapper.map(skillDTO, Skill.class);
	}

	public static SkillDTO mapSkillToSkillDTO(Skill skill){
		return modelMapper.map(skill, SkillDTO.class);
	}

	public static List<SkillDTO> mapSkillsToSkillDTOs(List<Skill> skills){
		return skills.stream().map(Mapper::mapSkillToSkillDTO).collect(Collectors.toList());
	}

	public static PersonalInformation mapPersonalInfDTOToPersonalInfo(PersonalInformationDTO personalInformationDTO){
		return modelMapper.map(personalInformationDTO, PersonalInformation.class);
	}

	public static PersonalInformationDTO mapPersonalInfoToPersonalInfoDTO(PersonalInformation personalInformation){
		return modelMapper.map(personalInformation, PersonalInformationDTO.class);
	}


}
