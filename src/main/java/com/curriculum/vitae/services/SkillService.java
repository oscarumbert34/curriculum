package com.curriculum.vitae.services;

import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.exceptions.TransactionException;

import java.util.List;

public interface SkillService {
    public void save(List<SkillDTO> entities) throws TransactionException;

    public List<SkillDTO> findAll();
}
