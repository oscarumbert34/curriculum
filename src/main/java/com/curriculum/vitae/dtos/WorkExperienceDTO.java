package com.curriculum.vitae.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDTO {

	@NotBlank
	private String business;
	
	@NotBlank
	private String job;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate initDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@Pattern(regexp="FINALIZE|ACTUALLY", message="El valor solo puede ser FINALIZE o ACTUALLY") // {validator.zip}
	@NotNull
	private String state;
	
	@NotBlank
	private String description;
}
