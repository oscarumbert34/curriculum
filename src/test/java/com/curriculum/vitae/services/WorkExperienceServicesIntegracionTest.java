package com.curriculum.vitae.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.curriculum.vitae.VitaeApplication;

@AutoConfigureMockMvc
@SpringBootTest(classes = { VitaeApplication.class })
public class WorkExperienceServicesIntegracionTest {

	@Autowired
	private WorkExperienceService service;
	
	@Test
	public void prueba() {
		service.save(null);
	}
}
