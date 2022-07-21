package com.curriculum.vitae.validators;

import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.models.PersonalInformation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInformationValidatorImpl implements PersonalInformationValidator{

    @Override
    public void validate(Optional<PersonalInformation> personalInformation) {
        if(personalInformation.isPresent()){
            throw new TransactionException("La informacion personal ya existe: numero de documento "+ personalInformation.get().getDocumentNumber());
        }
    }
}
