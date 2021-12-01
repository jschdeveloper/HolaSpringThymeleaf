package com.jschdeveloper.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		personaService.guardar(persona);

		return "redirect:/";

	}

	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarPersona(persona);

		model.addAttribute("persona", persona);

		return "modificar";
	}

	@GetMapping("eliminar")
	public String eliminar(Persona persona, Model model) {
		personaService.eliminar(persona);

		return "redirect:/";
	}

	@GetMapping("/health")
	public ResponseEntity<Object> health() {
		return ResponseEntity.ok("OK");

	}

}
