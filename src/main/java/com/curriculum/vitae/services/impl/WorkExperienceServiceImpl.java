package com.curriculum.vitae.services.impl;

import java.time.LocalDate;
import java.util.List;

import com.curriculum.vitae.services.ServiceGeneric;
import com.curriculum.vitae.services.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.repositories.WorkExperienceRepository;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

	private WorkExperienceRepository workExperienceRepository;
	
	@Autowired
	public WorkExperienceServiceImpl(WorkExperienceRepository workExperienceRepository) {
		super();
		this.workExperienceRepository = workExperienceRepository;
	}

	public void save(WorkExperienceDTO dto) throws TransactionException {
		
		if(!existExperience(dto.getBusiness(), dto.getInitDate())){
			workExperienceRepository.save(Mapper.mapWorkExperienceDTOtoWorkExperience(dto));
		}else {
			throw new TransactionException("La experiencia ya existe");
		}
		
	}
	
	private boolean existExperience(String business, LocalDate initDate) {
		return workExperienceRepository.findByBusinessAndInitDate(business, initDate).isPresent();
	}
	
	public WorkExperienceDTO findLast() {
		return workExperienceRepository.findFirstByOrderByInitDateDesc()
				.map(p -> Mapper.mapWorkExperienceToWorkExperienceDTO(p))
				.orElseThrow(() -> new TransactionException("No hay experiencias cargadas"));
	}
	
	public List<WorkExperienceDTO> findAll(){
		return Mapper.mapWorkExperiencesToWorkExperiencesDTO(workExperienceRepository.findAllByOrderByInitDateDesc());
	}

}
