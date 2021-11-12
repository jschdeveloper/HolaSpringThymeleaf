package com.jschdeveloper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("saludo", saludo);


		return "index";
	}

}
