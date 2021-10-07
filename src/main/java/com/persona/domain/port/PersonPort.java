package com.persona.domain.port;

import com.persona.domain.model.Person;

import java.util.List;

public interface PersonPort {
    List<Person> findByName(String name);
    List<Person> findAll();
    Person savePerson(Person person);
    Person findById(Integer id);
    void deletePersonById(Integer id);
}
