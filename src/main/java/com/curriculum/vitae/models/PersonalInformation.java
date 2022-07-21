package com.curriculum.vitae.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "personal_information")
public class PersonalInformation {

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	private String documentNumber;
	private String name;
	private String surname;
	private LocalDate birthday;
	private String email;
	private String cellphone;
	private String adress;
	private String gender;
	private String linkedin;
	
}
