package com.curriculum.vitae.dtos;

import java.time.LocalDate;

import com.curriculum.vitae.models.State;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkExperienceDTO {

	private String business;
	private String job;
	private LocalDate initDate;
	private LocalDate endDate;
	private State state;
	private String description;
}
