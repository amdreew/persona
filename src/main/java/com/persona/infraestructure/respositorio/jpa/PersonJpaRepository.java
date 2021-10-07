package com.persona.infraestructure.respositorio.jpa;

import com.persona.infraestructure.respositorio.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findByName(String name);
}
