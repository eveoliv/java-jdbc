package br.com.eveoliv.repository;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = new ConnectionFactory().getConexao()) {
			conn.setAutoCommit(false);

			String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

			try (PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				Produto p1 = new Produto();
				p1.setNome("Porta");
				p1.setDescricao("madeira colonial");

				adicionarComVariavel(p1, stm);

				Produto p2 = new Produto();
				p2.setNome("sapato");
				p2.setDescricao("com cadastro azul");

				adicionarComVariavel(p2, stm);

				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback ...");
				conn.rollback();
			}
		}
	}

	private static void adicionarComVariavel(Produto prd, PreparedStatement stm) throws SQLException {
		stm.setString(1, prd.getNome());
		stm.setString(2, prd.getDescricao());

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {

				System.out.println("Novo produto cadastrado com ID: [" + rst.getInt(1) + "]");
			}
		}
	}

}
