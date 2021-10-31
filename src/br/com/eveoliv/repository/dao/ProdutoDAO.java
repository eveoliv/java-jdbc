package br.com.eveoliv.repository.dao;

import java.sql.Statement;

import br.com.eveoliv.repository.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback ...");
			connection.rollback();
		}
	}
	
}