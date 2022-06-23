package com.curriculum.vitae.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInformation {

	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;
	private String cellphone;
	
}
