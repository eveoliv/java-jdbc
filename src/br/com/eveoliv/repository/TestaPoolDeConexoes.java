package br.com.eveoliv.repository;

import java.sql.SQLException;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conn = new ConnectionFactory();
		
		for (int i = 0; i < 5; i++) {
			
			conn.getConexao();
			System.out.println("Conexao numero: " + i);
		}
 
	}
	// no mysql, utilizar o comando show processlist para visualizar as requisicoes enviadas pela aplicacao
}
