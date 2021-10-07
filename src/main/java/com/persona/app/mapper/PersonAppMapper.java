package com.persona.app.mapper;

import com.persona.app.dto.PersonDTO;
import com.persona.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonAppMapper {
    Person dtoToDomain(PersonDTO personEntity);
    PersonDTO domainTodto(Person person);
}
