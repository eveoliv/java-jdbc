package br.com.eveoliv.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eveoliv.repository.model.Categoria;
import br.com.eveoliv.repository.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {

		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select * from categoria";

		try (PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.execute();

			try (ResultSet rst = psmt.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
		}

		return categorias;
	}

	public List<Categoria> listarComProduto() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		String sql = "select c.id, c.nome, p.id, p.nome from categoria c inner join produto p on p.categoria_id = c.id";

		try (PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.execute();

			try (ResultSet rst = psmt.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			}
		}

		return categorias;			
	}
}
