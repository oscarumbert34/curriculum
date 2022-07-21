package com.curriculum.vitae.controllers;

import java.util.List;

import com.curriculum.vitae.services.ServiceGeneric;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.services.WorkExperienceService;

@RestController
@RequestMapping(path = "/work-experience")
public class WorkExperienceController {

	
	private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		this.workExperienceService = workExperienceService;
	}
	
	@PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> save(
			@RequestBody @Validated WorkExperienceDTO workExperienceDTO) {
		workExperienceService.save(workExperienceDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
	}
	
	@GetMapping(value = "/last", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<WorkExperienceDTO> findLast() {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(workExperienceService.findLast());
	}

	@Operation(summary = "Obtiene todas las experiencias laborales desde la ultima hasta la primera")
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<WorkExperienceDTO>> findAll() {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(workExperienceService.findAll());
	}
	
}
