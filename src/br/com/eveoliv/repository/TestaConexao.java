package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connectionFactory = new ConnectionFactory().getConexao();

		System.out.println("Fechando conexao ....");
		connectionFactory.close();	
	}

}
