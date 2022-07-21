package com.curriculum.vitae.validators;

import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.models.Skill;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class SkillValidatorsImpl implements SkillValidator {

    @Override
    public void validate(SkillDTO skillDTO) {

        if(skillDTO.getLevel()<1 || skillDTO.getLevel()>5){
            throw new TransactionException("Rango de nivel incorrecto: el rango debe estar entre 1 y 5");
        }
    }

    @Override
    public void validate(Optional<Skill> skill) {
        if(skill.isPresent()){
            throw new TransactionException("El skill ya existe");
        }
    }


}
