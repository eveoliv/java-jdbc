package br.com.eveoliv.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	protected String url = "jdbc:mysql://127.0.0.1:33061/loja_virtual?useTimezone=true&serverTimezone=UTC";
	
	public DataSource dataSource;

	public ConnectionFactory() {

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		comboPooledDataSource.setMaxPoolSize(3);		
		
		this.dataSource = comboPooledDataSource;
	}

	public Connection getConexao() throws SQLException {

//		String host = "127.0.0.1";
//		String port = "33061";
//		String database = "loja_virtual";
//		String user = "root";
//		String pwd = "root";
//		String stringConn = "jdbc:mysql://" + host + ":" + port + "/"+ database +"?useTimezone=true&serverTimezone=UTC";		
//		Connection conn = DriverManager.getConnection(stringConn, user, pwd);

//		System.out.println("Abrindo conexao .... ");
//		return DriverManager.getConnection(url, "root", "root");

		return this.dataSource.getConnection();
	}
}
