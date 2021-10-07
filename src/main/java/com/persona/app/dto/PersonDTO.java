package com.persona.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Integer id;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String name;
    @NotNull(message = "no puede ser nulo")
    @NotEmpty(message = "no puede ser vacio")
    private String cellphone;
    @NotNull(message = "no puede ser nulo")
    private Integer age;
}
