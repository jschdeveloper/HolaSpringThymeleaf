package com.jschdeveloper.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jschdeveloper.domain.Persona;
import com.jschdeveloper.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model) {
		log.info("Ejecutando controlador Spring MVC");

		List<Persona> pesonas = personaService.listarPersonas();

		model.addAttribute("personas", pesonas);

		return "index";
	}

	@GetMapping("/health")
	public ResponseEntity<Object> health() {
		return ResponseEntity.ok("OK");

	}

}
