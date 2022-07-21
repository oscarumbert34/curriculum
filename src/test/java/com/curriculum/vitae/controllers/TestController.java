package com.curriculum.vitae.controllers;

import com.curriculum.vitae.utils.GenerateObjects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Getter;

@Getter
public class TestController extends GenerateObjects {
	
	private ObjectMapper mapper;

	protected void init() {
		mapper = new ObjectMapper().findAndRegisterModules().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	protected String toJson(final Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}
	
}
