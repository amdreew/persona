package com.persona.domain.service;

import com.persona.domain.model.Person;
import com.persona.domain.port.PersonPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonPort personPort;

    public List<Person> findByName(String name) {
        return this.personPort.findByName(name);
    }
    public List<Person> findAll() {
        return this.personPort.findAll();
    }
    public Person savePerson(Person person) {
        return this.personPort.savePerson(person);
    }
    public Person findById(Integer id) {
       return this.personPort.findById(id);
    }
    public void deletePersonById(Integer id) {
      this.personPort.deletePersonById(id);
    }
}
