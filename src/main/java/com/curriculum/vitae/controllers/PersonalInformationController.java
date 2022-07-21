package com.curriculum.vitae.controllers;

import com.curriculum.vitae.dtos.PersonalInformationDTO;
import com.curriculum.vitae.services.PersonalInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/personal-information")
public class PersonalInformationController {

    private PersonalInformationService personalInformationService;

    public PersonalInformationController(PersonalInformationService personalInformationService){
        this.personalInformationService = personalInformationService;
    }

    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> save(
            @RequestBody @Validated PersonalInformationDTO personalInformationDTO) {
        personalInformationService.save(personalInformationDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
    }

    @GetMapping(value = "/document-number/{documentNumber}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<PersonalInformationDTO> findDocumentNumber(@PathVariable String documentNumber) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personalInformationService.findByDocumentNumber(documentNumber));
    }
}
