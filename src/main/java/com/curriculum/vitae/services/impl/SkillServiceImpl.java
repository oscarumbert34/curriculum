package com.curriculum.vitae.services.impl;

import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.exceptions.TransactionException;
import com.curriculum.vitae.mappers.Mapper;
import com.curriculum.vitae.repositories.SkillRepository;
import com.curriculum.vitae.services.SkillService;
import com.curriculum.vitae.validators.SkillValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    private SkillValidator skillValidator;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository, SkillValidator skillValidator){
        this.skillRepository = skillRepository;
        this.skillValidator = skillValidator;
    }

    @Override
    public void save(List<SkillDTO> entities) throws TransactionException {

        entities.stream().forEach(entity -> {
            skillValidator.validate(entity);
            skillValidator.validate(skillRepository.findByName(entity.getName()));
        });
        entities.stream().forEach(entity -> skillRepository.save(Mapper.mapSkillDTOtoSkill(entity)));
    }
    @Override
    public List<SkillDTO> findAll() {

        return Mapper.mapSkillsToSkillDTOs(skillRepository.findAll());
    }
}
