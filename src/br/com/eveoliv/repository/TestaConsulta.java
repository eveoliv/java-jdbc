package br.com.eveoliv.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConsulta {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = new ConnectionFactory().getConexao();		

		Statement stm = conn.createStatement();
		boolean resulado = stm.execute("SELECT * FROM PRODUTO");
		
		if (resulado) 
			System.out.println("Consulta executada com sucesso!!!!");
		
		ResultSet rst = stm.getResultSet();
		
		while (rst.next()) {
			
			Integer id = rst.getInt("id");
			String nome = rst.getString("nome");
			String desc = rst.getString("descricao");
			
			System.out.println("ID: [" + id + "] Nome: [" + nome + "] Descricao: [" + desc + "]");
		}
		
		System.out.println("Fechando conexao ....");
		conn.close();	
	}

}
