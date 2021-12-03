package com.jschdeveloper.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Accessors(chain=true, fluent=true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;

	@NotEmpty(message = "{message.validate.notEmpty.person.name}")

	private String nombre;

	@NotEmpty(message = "{message.validate.notEmpty.person.lastname}")
	private String apellido;

	@NotEmpty(message = "{message.validate.notEmpty.person.email}")
	@Email(message = "{message.validate.person.email}")
	private String email;

	private String telefono;

}
