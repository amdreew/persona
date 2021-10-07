package com.persona.app.port;

import com.persona.app.dto.PersonDTO;

import java.util.List;

public interface PersonAppPort {
    List<PersonDTO> findByName(String name);
    List<PersonDTO> findAll();
    PersonDTO savePerson(PersonDTO person);
    PersonDTO updatePerson(PersonDTO person);
    PersonDTO findById(Integer id);
    String deletePersonById(Integer id);
}
