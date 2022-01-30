package com.jschdeveloper.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "rol")
//nombre de la tabla igual que en la BD
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // por que se puso autoincrementable en Mysql
	private Long idRol;

	@NotEmpty(message = "name is required file")
	private String nombre;

}
