package com.jschdeveloper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jschdeveloper.domain.Persona;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

	@Value(value = "${index.saludos}")
	private String saludo;

	@GetMapping("/")
	public String inicio(Model model) {
		log.info("Ejecutando controlador Spring MVC");
		String mensaje = "Mensaje con thymeleaf:";
		Persona persona = new Persona("Jesús", "Sánchez", "jesus.sanchez@gmail.com", "2288461196");

		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);
		model.addAttribute("persona", persona);

		return "index";
	}

}
