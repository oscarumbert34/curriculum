package com.curriculum.vitae.controllers;

import java.util.List;

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

import com.curriculum.vitae.dtos.SkillDTO;
import com.curriculum.vitae.services.SkillService;

@RestController
@RequestMapping(path = "/skill")
public class SkillController {

	
	private SkillService skillService;
	
	@Autowired
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	
	@PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> save(
			@RequestBody @Validated List<SkillDTO> skillDTOS) {
		skillService.save(skillDTOS);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
	}
	
	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SkillDTO>> findAll() {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillService.findAll());
	}
}
