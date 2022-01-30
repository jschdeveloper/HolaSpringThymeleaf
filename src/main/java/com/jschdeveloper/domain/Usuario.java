package com.jschdeveloper.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // por que se puso autoincrementable en Mysql
	private Long idUsuario;

	@NotEmpty(message = "username is required file")
	private String username;

	@NotEmpty(message = "password is required file")
	private String password;

	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Rol> roles;

}
