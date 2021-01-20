package com.angoti.recuperacao.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/crud")
	public String crud() {
		return "index";
	}

}
