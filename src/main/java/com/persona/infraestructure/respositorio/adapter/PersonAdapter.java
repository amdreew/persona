package com.persona.infraestructure.respositorio.adapter;

import com.persona.domain.model.Person;
import com.persona.domain.port.PersonPort;
import com.persona.infraestructure.respositorio.jpa.PersonJpaRepository;
import com.persona.infraestructure.respositorio.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonAdapter implements PersonPort {

    private final PersonMapper mapper;
    private final PersonJpaRepository repository;

    @Override
    public List<Person> findByName(String name) {
        return this.repository.findByName(name)
                .stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Person savePerson(Person person) {
        return this.mapper.entityToDomain(this.repository.save(this.mapper.domainToEntity(person)));
    }

    @Override
    public Person findById(Integer id) {
        return this.mapper.entityToDomain(this.repository.findById(id).orElse(null));
    }

    @Override
    public void deletePersonById(Integer id) {
        this.repository.deleteById(id);
    }
}
