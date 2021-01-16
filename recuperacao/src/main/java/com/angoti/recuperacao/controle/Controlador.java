package com.angoti.recuperacao.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/exemplo")
	public String exemplo() {
		System.out.println("---------------->");
		return "exemplo";
	}

}
