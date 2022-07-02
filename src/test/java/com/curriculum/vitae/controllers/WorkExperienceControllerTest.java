package com.curriculum.vitae.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.curriculum.vitae.dtos.WorkExperienceDTO;
import com.curriculum.vitae.exceptions.ErrorResponse;
import com.curriculum.vitae.exceptions.ValidationError;
import com.curriculum.vitae.handler.Handler;
import com.curriculum.vitae.services.WorkExperienceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@EnableWebMvc
@ExtendWith(MockitoExtension.class)
class WorkExperienceControllerTest {

	private MockMvc mockMvc;

	private ObjectMapper mapper;
	
	@Mock
	private WorkExperienceService workExperienceService;
 
	@InjectMocks
	private WorkExperienceController workExperienceController;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(workExperienceController).setControllerAdvice(new Handler()).build();
		mapper = new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
	}
	
	@ParameterizedTest(name = "{index} => workExperienceDTO={0}, field={1}, message={2}")
    @MethodSource("data")
	void whenInitDateIsNull(WorkExperienceDTO workExperienceDTO, String field, String message) throws JsonProcessingException, Exception {
		ErrorResponse error = toObject(this.executePost(workExperienceDTO));
		assertThat(error).extracting("validationErrors").asList()
		.containsOnly(new ValidationError(message,field));
		
	}
	
	private static Stream<Arguments> data() {
		WorkExperienceDTO workExperienceDTO = createDto();
		workExperienceDTO.setInitDate(null);
		
		WorkExperienceDTO workExperienceDTO2 = createDto();
		workExperienceDTO2.setBusiness(null);
		
		WorkExperienceDTO workExperienceDTO3 = createDto();
		workExperienceDTO3.setBusiness("");
		
		WorkExperienceDTO workExperienceDTO4 = createDto();
		workExperienceDTO4.setJob(null);
		
		WorkExperienceDTO workExperienceDTO5 = createDto();
		workExperienceDTO5.setJob("");
		
		WorkExperienceDTO workExperienceDTO6 = createDto();
		workExperienceDTO6.setState("");
		
		WorkExperienceDTO workExperienceDTO7 = createDto();
		workExperienceDTO7.setState("dsadas");
		
		WorkExperienceDTO workExperienceDTO8 = createDto();
		workExperienceDTO8.setState(null);
		
		WorkExperienceDTO workExperienceDTO9 = createDto();
		workExperienceDTO9.setDescription("");
		
		WorkExperienceDTO workExperienceDTO10 = createDto();
		workExperienceDTO10.setDescription(null);
		
		return Stream.of(Arguments.of(workExperienceDTO, "initDate", "must not be null"),
				Arguments.of(workExperienceDTO2, "business", "must not be blank"),
				Arguments.of(workExperienceDTO3, "business", "must not be blank"),
				Arguments.of(workExperienceDTO4, "job", "must not be blank"),
				Arguments.of(workExperienceDTO5, "job", "must not be blank"),
				Arguments.of(workExperienceDTO6, "state", "El valor solo puede ser FINALIZE o ACTUALLY"),
				Arguments.of(workExperienceDTO7, "state", "El valor solo puede ser FINALIZE o ACTUALLY"),
				Arguments.of(workExperienceDTO8, "state", "must not be null"),
				Arguments.of(workExperienceDTO9, "description", "must not be blank"),
				Arguments.of(workExperienceDTO10, "description", "must not be blank"));
	}
	private String toJson(final Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}
	
	private static WorkExperienceDTO createDto() {
		return WorkExperienceDTO.builder().description("dfsdf").business("T4T")
				.endDate(LocalDate.now()).job("Desarrollador Java").state("ACTUALLY")
				.initDate(LocalDate.now()).build();
	}
	
	
	private ErrorResponse toObject(final String json) throws JsonProcessingException {
		ErrorResponse errorResponse =  mapper.readValue(json, ErrorResponse.class);
		List<ValidationError> validationErrors = errorResponse.getFieldErrors().stream()
				.distinct().collect(Collectors.toList());
		errorResponse.setValidationErrors(validationErrors);
		return errorResponse;
	}
	
	private String executePost(WorkExperienceDTO workExperienceDTO) throws JsonProcessingException, Exception {
		MvcResult result = mockMvc
				.perform(post("/work-experience")
						.contentType(MediaType.APPLICATION_JSON).content(toJson(workExperienceDTO)))
				.andExpect(status().isBadRequest()).andReturn();
		return result.getResponse().getContentAsString();
	}
}
