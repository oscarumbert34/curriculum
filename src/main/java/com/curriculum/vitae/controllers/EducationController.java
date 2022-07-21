package com.curriculum.vitae.controllers;

import com.curriculum.vitae.dtos.EducationDTO;
import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.services.EducationService;
import com.curriculum.vitae.services.ServiceGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> save(
            @RequestBody @Validated EducationDTO educationDTO) {
        educationService.save(educationDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
    }

    @GetMapping(value = "/last", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<EducationDTO> findLast() {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(educationService.findLast());
    }

    @GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<EducationDTO>> findAll() {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(educationService.findAll());
    }
}
