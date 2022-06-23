package com.curriculum.vitae.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Education {

	private String career;
	private String institute;
	private LocalDate initDate;
	private LocalDate endDate;
	private String description;
	private State state;
}
