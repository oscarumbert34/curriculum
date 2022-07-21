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
@Table(name = "education")
public class Education {

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	private String career;
	private String institute;
	private LocalDate initDate;
	private LocalDate endDate;
	private String description;

	@Column(name = "state", nullable = false)
	@Enumerated(EnumType.STRING)
	private State state;
}
