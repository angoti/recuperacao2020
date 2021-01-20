package com.angoti.recuperacao.controle;

import com.angoti.recuperacao.dao.AlunoDAO;
import com.angoti.recuperacao.dominio.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Controlador {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/crud")
	public String crud(Model modelo) {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.buscarTodos();
		modelo.addAttribute("alunos",lista);
		return "index";
	}

}
