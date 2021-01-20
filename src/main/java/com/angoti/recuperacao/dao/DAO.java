package com.angoti.recuperacao.dao;

import java.util.List;

public interface DAO<T> {

	T buscarPorID(int id);

	void criar(T entity);

	void atualizar(T entity);

	void excluir(int id);

	List<T> buscarTodos();
}
