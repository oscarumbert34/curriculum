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
public class WorkExperienceControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper;

	//@Mock
	private WorkExperienceService workExperienceService;
 
	//@InjectMocks
	private WorkExperienceController workExperienceController;
	
	@BeforeEach
	public void setUp() {
		///mockMvc = MockMvcBuilders.standaloneSetup(workExperienceController).setControllerAdvice(new Handler()).build();
		mapper = new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		//workExperienceController = new WorkExperienceController(workExperienceService);
	}
	
	@Test
	public void whenTest() throws JsonProcessingException, Exception {
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
	
	private String toJson(final Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}
	
}
