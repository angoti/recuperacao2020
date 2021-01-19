package com.angoti.recuperacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.angoti.recuperacao.dominio.Aluno;

public class AlunoDAO implements DAO<Aluno> {

	private String selecionaTodos = "select * from alunos";
	private String selecionaPorID = "select * from alunos where id=?";
	private String atualiza = "update alunos set nome = ? where id = ?";
	private String exclui = "delete from alunos where id=?";
	private String cria = "insert into alunos(nome) values (?)";

	Connection conexao;
	PreparedStatement consulta;

	public AlunoDAO() {
		super();
		conexao = FabricaDeConexao.getConnection();
	}

	@Override
	public Aluno buscarPorID(int id) {
		PreparedStatement consulta;
		Aluno aluno = null;
		try {
			consulta = conexao.prepareStatement(selecionaPorID);
			consulta.setInt(1, id);
			ResultSet retorno = consulta.executeQuery();
			retorno.next();
			aluno = new Aluno(id, retorno.getString("nome"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	@Override
	public void criar(Aluno entity) {
		try {
			consulta = conexao.prepareStatement(cria);
			consulta.setString(1, entity.getNome());
			consulta.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void atualizar(Aluno entity) {
		try {
			consulta = conexao.prepareStatement(atualiza);
			consulta.setString(1, entity.getNome());
			consulta.setInt(2, entity.getId());
			consulta.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void excluir(int id) {
		try {
			consulta = conexao.prepareStatement(exclui);
			consulta.setInt(1, id);
			consulta.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	}

	@Override
	public List<Aluno> buscarTodos() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			consulta = conexao.prepareStatement(selecionaTodos);
			ResultSet retorno = consulta.executeQuery();
			while (retorno.next()) {
				Aluno aluno = new Aluno(retorno.getInt("idalunos"), retorno.getString("nome"));
				lista.add(aluno);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	
}
