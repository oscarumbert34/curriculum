package com.curriculum.vitae.models;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "work_experience")
@Builder
public class WorkExperience {

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	@GeneratedValue(generator = "uuid2") 
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;
	
	private String business;
	private String job;
	private LocalDate initDate;
	private LocalDate endDate;
	private State state;
	private String description;
	
}
