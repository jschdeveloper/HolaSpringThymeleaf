package com.jschdeveloper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jschdeveloper.dao.PersonaDAO;
import com.jschdeveloper.domain.Persona;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

	@Autowired
	private PersonaDAO personaDAO;

	@GetMapping("/")
	public String inicio(Model model) {
		log.info("Ejecutando controlador Spring MVC");

		Iterable<Persona> pesonas = personaDAO.findAll();

		model.addAttribute("personas", pesonas);

		return "index";
	}

}
