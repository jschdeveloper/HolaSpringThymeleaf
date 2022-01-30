package com.jschdeveloper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jschdeveloper.domain.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
