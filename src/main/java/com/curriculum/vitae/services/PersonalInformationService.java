package com.curriculum.vitae.services;

import com.curriculum.vitae.dtos.PersonalInformationDTO;

public interface PersonalInformationService {
    void save(PersonalInformationDTO personalInformationDTO);
    PersonalInformationDTO findByDocumentNumber(String documentNumber);
}
