package com.curriculum.vitae.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.curriculum.vitae.VitaeApplication;
import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.handler.Handler;
import com.curriculum.vitae.models.State;
import com.curriculum.vitae.services.WorkExperienceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@AutoConfigureMockMvc
@SpringBootTest(classes = { VitaeApplication.class })
class WorkExperienceControllerIntegrationTest extends TestController{

	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		this.init();
	}
	
	@Test
	void whenTest() throws JsonProcessingException, Exception {
		WorkExperienceDTO workExperienceDTO = WorkExperienceDTO.builder().description("dfsdf")
				.state("FINALIZE").business("T4T").description("dsafsd").endDate(LocalDate.now())
				.initDate(LocalDate.now()).job("").build();
		MvcResult result = mockMvc
				.perform(post("/work-experience")
						.contentType(MediaType.APPLICATION_JSON).content(toJson(workExperienceDTO)))
				.andExpect(status().isBadRequest()).andReturn();
		String response = result.getResponse().getContentAsString();
				
		//workExperienceController.findAll();
	}
	
}
