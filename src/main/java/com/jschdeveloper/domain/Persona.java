package com.jschdeveloper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Accessors(chain=true, fluent=true)
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;

}
