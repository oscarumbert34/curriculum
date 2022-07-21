package com.curriculum.vitae.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class EducationDTO {

    @NotBlank
    private String career;

    @NotBlank
    private String institute;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate initDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank
    private String description;

    @Pattern(regexp="FINALIZE|ACTUALLY", message="El valor solo puede ser FINALIZE o ACTUALLY") // {validator.zip}
    @NotNull
    private String state;
}
