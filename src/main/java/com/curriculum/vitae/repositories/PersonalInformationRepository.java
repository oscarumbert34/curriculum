package com.curriculum.vitae.repositories;

import com.curriculum.vitae.models.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, UUID> {
    Optional<PersonalInformation> findByDocumentNumber(String documentNumber);
}
