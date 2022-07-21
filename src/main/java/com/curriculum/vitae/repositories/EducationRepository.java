package com.curriculum.vitae.repositories;

import com.curriculum.vitae.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {

    Optional<Education> findByCareerAndInitDate(String carrer, LocalDate initDate);

    Optional<Education> findFirstByOrderByInitDateDesc();

}
