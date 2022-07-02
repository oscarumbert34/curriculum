package com.curriculum.vitae.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse implements Serializable{

	private final int status;
	private final String message;
	private List<ValidationError> validationErrors = new ArrayList<>();

	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public void addFieldError(String field, String message) {
		ValidationError error = new ValidationError(message, field);
		validationErrors.add(error);
	}

	public List<ValidationError> getFieldErrors() {
		return validationErrors;
	}
}
