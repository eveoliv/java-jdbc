package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConexao() throws SQLException {

//		String host = "127.0.0.1";
//		String port = "33061";
//		String database = "loja_virtual";
//		String user = "root";
//		String pwd = "root";
//		String stringConn = "jdbc:mysql://" + host + ":" + port + "/"+ database +"?useTimezone=true&serverTimezone=UTC";		
//		Connection conn = DriverManager.getConnection(stringConn, user, pwd);

		System.out.println("Abrindo conexao .... ");
		return DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:33061/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");
		
	}
}
