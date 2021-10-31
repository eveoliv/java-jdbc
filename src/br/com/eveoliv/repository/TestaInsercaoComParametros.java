package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.eveoliv.repository.dao.ProdutoDAO;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {
		
		Produto produto =  new Produto("roda","redonda");
		try (Connection connection = new ConnectionFactory().getConexao()) {
			
			ProdutoDAO persistencia = new ProdutoDAO(connection);
			persistencia.salvar(produto);
			//persistencia.listarProduto...
		}
	}	

}
