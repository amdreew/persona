package com.persona.infraestructure.respositorio.mapper;


import com.persona.domain.model.Person;
import com.persona.infraestructure.respositorio.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {
    Person entityToDomain(PersonEntity personEntity);
    PersonEntity domainToEntity(Person person);
}
