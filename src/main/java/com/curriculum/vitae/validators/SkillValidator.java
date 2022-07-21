package com.curriculum.vitae.validators;

import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.models.Skill;

import java.util.Optional;

public interface SkillValidator {
    void validate(SkillDTO skillDTO);
    void validate(Optional<Skill> skill);
}
