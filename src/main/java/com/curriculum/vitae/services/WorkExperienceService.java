package com.curriculum.vitae.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.models.WorkExperience;
import com.curriculum.vitae.repositories.WorkExperienceRepository;

@Service
public class WorkExperienceService {

	private WorkExperienceRepository workExperienceRepository;
	
	@Autowired
	public WorkExperienceService(WorkExperienceRepository workExperienceRepository) {
		super();
		this.workExperienceRepository = workExperienceRepository;
	}

	public void save(WorkExperienceDTO WorkExperienceDTO) {
		WorkExperience work = WorkExperience.builder().job("Java Backend").
				description("jdfjkhsdkf").initDate(LocalDate.now()).business("T4T").build();
		workExperienceRepository.save(work);
	}
	
	public WorkExperienceDTO findLast() {
		return null;
	}
	
	public List<WorkExperienceDTO> findAll(){
		return null;
	}
}
