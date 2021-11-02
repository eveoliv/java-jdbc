package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.eveoliv.repository.dao.CategoriaDAO;
import br.com.eveoliv.repository.dao.ProdutoDAO;
import br.com.eveoliv.repository.model.Categoria;
import br.com.eveoliv.repository.model.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().getConexao()) {

			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProduto();

			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
//				try {
//					for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
//						System.out.println(ct.getNome() + " - " + produto.getNome());
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			});
		}

	}

}
