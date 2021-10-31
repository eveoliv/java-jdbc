package br.com.eveoliv.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		Connection conn = new ConnectionFactory().getConexao();

		Statement stm = conn.createStatement();

		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('borracha','caixa com 10 unidades')",
				Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			
			System.out.println("Novo produto cadastrado com ID: [" + rst.getInt(1) + "]");
		}
		
		System.out.println("Fechando conexao ....");
		conn.close();
	}

}
