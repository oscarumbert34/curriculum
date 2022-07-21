package com.curriculum.vitae.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curriculum.vitae.models.WorkExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, UUID> {

	Optional<WorkExperience> findByBusinessAndInitDate(String business, LocalDate initDate);
	Optional<WorkExperience> findFirstByOrderByInitDateDesc();

	List<WorkExperience> findAllByOrderByInitDateDesc();
}
