package br.com.eveoliv.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaDelecao {

	public static void main(String[] args) throws SQLException {

		Connection conn = new ConnectionFactory().getConexao();
		
		Statement stm = conn.createStatement();
		
		String id = "5";
		
		stm.execute("DELETE FROM PRODUTO WHERE ID = " + id);				
		
		Integer alteracao = stm.getUpdateCount();
		
		System.out.println("Deletando produto com ID: [" + id + "]");
		System.out.println("Linhas afetadas: " + alteracao);
		System.out.println("Fechando conexao ....");
		conn.close();
	}

}
