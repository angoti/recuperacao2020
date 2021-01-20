package com.angoti.recuperacao.controle;

import com.angoti.recuperacao.dao.AlunoDAO;
import com.angoti.recuperacao.dominio.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controlador {

    AlunoDAO dao = new AlunoDAO();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/crud")
    public String crud(Model modelo) {
        List<Aluno> lista = dao.buscarTodos();
        modelo.addAttribute("alunos", lista);
        return "index";
    }

    @GetMapping("/criar")
    public String exibeFormulario(Model modelo) {
        modelo.addAttribute("aluno", new Aluno());
        return "novo";
    }

    @PostMapping("/gravar")
    public String gravar(Aluno aluno) {
        if (aluno.getId() == 0) {
            dao.criar(aluno);
        }else{
            dao.atualizar(aluno);
        }
        return "redirect:/crud";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam("id") int id) {
        dao.excluir(id);
        return "redirect:/crud";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model modelo) {
        Aluno aluno = dao.buscarPorID(id);
        modelo.addAttribute("aluno", aluno);
        return "novo";
    }
}
