package com.curriculum.vitae.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkExperience {

	private String business;
	private String job;
	private LocalDate initDate;
	private LocalDate endDate;
	private State state;
	private String description;
	
}
