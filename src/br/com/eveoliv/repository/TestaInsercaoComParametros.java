package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.eveoliv.repository.dao.ProdutoDAO;
import br.com.eveoliv.repository.model.Produto;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {
		
		Produto produto =  new Produto("roda","redonda");
		try (Connection connection = new ConnectionFactory().getConexao()) {
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(produto);
			List<Produto> lista = produtoDAO.listar();
			lista.stream().forEach(p -> System.out.println(p));
		}
	}	

}
