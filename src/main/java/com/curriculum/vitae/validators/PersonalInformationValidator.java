package com.curriculum.vitae.validators;

import com.curriculum.vitae.models.PersonalInformation;

import java.util.Optional;

public interface PersonalInformationValidator {
    void validate(Optional<PersonalInformation> personalInformation);
}
