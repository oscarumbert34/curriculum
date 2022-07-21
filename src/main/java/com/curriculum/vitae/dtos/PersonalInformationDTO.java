package com.curriculum.vitae.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class PersonalInformationDTO {


    @NotBlank
    @Pattern(regexp="[0-9]*")
    @Max(99999999)
    private String documentNumber;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp="[0-9]*")
    private String cellphone;

    @NotBlank
    private String adress;

    @Pattern(regexp="MALE|FEMALE", message="El Genero solo puede ser FEMALE o MALE") // {validator.zip}
    private String gender;

    private String linkedin;

}
