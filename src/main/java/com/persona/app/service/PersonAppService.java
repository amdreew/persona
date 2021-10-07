package com.persona.app.service;

import com.persona.app.dto.PersonDTO;
import com.persona.app.mapper.PersonAppMapper;
import com.persona.app.port.PersonAppPort;
import com.persona.domain.exception.RequiredValueException;
import com.persona.domain.model.Person;
import com.persona.domain.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonAppService implements PersonAppPort {

    private final PersonService service;
    private final PersonAppMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<PersonDTO> findByName(String name) {
        return this.service.findByName(name)
                .stream()
                .map(mapper::domainTodto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonDTO> findAll() {
        return this.service.findAll()
                .stream()
                .map(mapper::domainTodto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonDTO savePerson(PersonDTO person) {
        person.setId(null);
        return this.mapper.domainTodto(this.service.savePerson(this.mapper.dtoToDomain(person)));
    }

    @Override
    @Transactional
    public PersonDTO updatePerson(PersonDTO person) {
        if(person.getId() != null) {
            Person currentPerson = this.service.findById(person.getId());
            if(currentPerson != null) {
                return this.mapper.domainTodto(this.service.savePerson(this.mapper.dtoToDomain(person)));
            }
            throw new RequiredValueException("Esta persona con id: "+ person.getId() + " no se encuentra registrada!");
        }
        throw new RequiredValueException("id obligatorio");
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDTO findById(Integer id) {
        return this.mapper.domainTodto(this.service.findById(id));
    }

    @Override
    @Transactional
    public String deletePersonById(Integer id) {
        if(id != null) {
            Person currentPerson = this.service.findById(id);
            if(currentPerson != null) {
                this.service.deletePersonById(id);
                return "la persona con id" + id + " ha sido eliminada con exito";
            }
            throw new RequiredValueException("Esta persona con id: "+ id + " no se encuentra registrada!");
        }
        throw new RequiredValueException("id obligatorio");
    }
}
