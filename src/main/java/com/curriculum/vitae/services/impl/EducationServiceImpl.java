package com.curriculum.vitae.services.impl;

import com.curriculum.vitae.dtos.EducationDTO;
import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.repositories.EducationRepository;
import com.curriculum.vitae.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }
    @Override
    public void save(EducationDTO entity) throws TransactionException {
        if(!this.existEducation(entity.getCareer(), entity.getInitDate())){
            educationRepository.save(Mapper.mapEducationDTOToEducation(entity));
        }else {
            throw new TransactionException("La educacion ya existe");
        }
    }

    @Override
    public EducationDTO findLast() {
        return educationRepository.findFirstByOrderByInitDateDesc()
                .map(p -> Mapper.mapEducationToEducationDTO(p))
                .orElseThrow(() -> new TransactionException("No hay educaciones cargadas"));
    }

    @Override
    public List<EducationDTO> findAll() {
        return Mapper.mapEducationsToEducationDTOs(educationRepository.findAll());
    }

    private boolean existEducation(String carrer, LocalDate initDate) {
        return educationRepository.findByCareerAndInitDate(carrer, initDate).isPresent();
    }
}
