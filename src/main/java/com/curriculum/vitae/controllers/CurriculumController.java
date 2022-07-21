package com.curriculum.vitae.controllers;

import com.curriculum.vitae.dtos.CurriculumDTO;
import com.curriculum.vitae.dtos.PersonalInformationDTO;
import com.curriculum.vitae.facade.CurriculumVitaeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/curriculum")
public class CurriculumController {

    private CurriculumVitaeFacade curriculumVitaeFacade;

    @Autowired
    public CurriculumController(CurriculumVitaeFacade curriculumVitaeFacade){
        this.curriculumVitaeFacade = curriculumVitaeFacade;
    }

    @GetMapping(value = "/document-number/{documentNumber}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CurriculumDTO> findByDocumentNumber(@PathVariable String documentNumber) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(curriculumVitaeFacade.getAll(documentNumber));
    }
}
