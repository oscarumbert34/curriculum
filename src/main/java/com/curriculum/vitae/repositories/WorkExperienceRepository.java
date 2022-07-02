package com.curriculum.vitae.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curriculum.vitae.models.WorkExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, UUID> {

}
