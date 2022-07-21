package com.curriculum.vitae.models;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "work_experience")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state;

	@Column(columnDefinition = "LONGTEXT")
	private String description;
	
}
