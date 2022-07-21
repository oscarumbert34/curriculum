package com.curriculum.vitae.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;

import com.curriculum.vitae.exceptions.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curriculum.vitae.exceptions.ErrorResponse;


@ControllerAdvice
public class Handler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handlerException(MethodArgumentNotValidException e) {
		logger.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(processFieldErrors(e));

	}
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorResponse> handlerException(TransactionException e) {
		logger.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(BAD_REQUEST.value(),e.getMessage()));

	}


	
	private ErrorResponse processFieldErrors(MethodArgumentNotValidException e) {
		ErrorResponse error = new ErrorResponse(BAD_REQUEST.value(), "validation error");
		List<FieldError>  fieldErrors = e.getBindingResult().getFieldErrors();

		for (org.springframework.validation.FieldError fieldError : fieldErrors) {
			error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return error;
	}
}
