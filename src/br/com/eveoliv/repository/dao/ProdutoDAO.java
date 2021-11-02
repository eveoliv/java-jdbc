package br.com.eveoliv.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.eveoliv.repository.model.Categoria;
import br.com.eveoliv.repository.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "insert into produto (nome, descricao) values (?, ?)";
		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());

			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {

		String sql = "select * from produto";

		List<Produto> produtos = new ArrayList<Produto>();

		try (PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.execute();

			try (ResultSet rst = psmt.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}

		return produtos;
	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
		
		
		String sql = "select * from produto where categoria_id = ?";

		List<Produto> produtos = new ArrayList<Produto>();

		try (PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.setInt(1, ct.getId());
			psmt.execute();

			try (ResultSet rst = psmt.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}

		return produtos;
		
	}
}