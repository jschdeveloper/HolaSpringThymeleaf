package com.jschdeveloper.dao;

import org.springframework.data.repository.CrudRepository;

import com.jschdeveloper.domain.Persona;

public interface PersonaDAO extends CrudRepository<Persona, Long> {

}
