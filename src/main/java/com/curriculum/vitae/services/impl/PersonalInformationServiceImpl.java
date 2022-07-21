package com.curriculum.vitae.services.impl;

import com.curriculum.vitae.dtos.PersonalInformationDTO;
import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.repositories.PersonalInformationRepository;
import com.curriculum.vitae.services.PersonalInformationService;
import com.curriculum.vitae.validators.PersonalInformationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    private PersonalInformationRepository personalInformationRepository;

    private PersonalInformationValidator personalInformationValidator;

    @Autowired
    public PersonalInformationServiceImpl(PersonalInformationRepository personalInformationRepository,
                                          PersonalInformationValidator personalInformationValidator){
         this.personalInformationRepository = personalInformationRepository;
         this.personalInformationValidator = personalInformationValidator;
    }

    @Override
    public void save(PersonalInformationDTO personalInformationDTO) {
        personalInformationValidator.validate(personalInformationRepository
                .findByDocumentNumber(personalInformationDTO.getDocumentNumber()));
        personalInformationRepository.save(Mapper.mapPersonalInfDTOToPersonalInfo(personalInformationDTO));
    }

    @Override
    public PersonalInformationDTO findByDocumentNumber(String documentNumber) {

        return personalInformationRepository.findByDocumentNumber(documentNumber)
                .map(p -> Mapper.mapPersonalInfoToPersonalInfoDTO(p))
                .orElseThrow(() -> new TransactionException("La persona con el documento : "+documentNumber+" no existe"));
    }
}
