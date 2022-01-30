package com.jschdeveloper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jschdeveloper.domain.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Long> {

}
