package com.jschdeveloper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jschdeveloper.dao.UsuarioDAO;
import com.jschdeveloper.domain.Rol;
import com.jschdeveloper.domain.Usuario;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> roles = new ArrayList<>();

		// mapeamos los roles guardados en BD en roles que entienda SpringSecurity
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}

		// creamos un nuevo usuario de spring
		return new User(usuario.getUsername(), usuario.getPassword(), roles);
	}

}
