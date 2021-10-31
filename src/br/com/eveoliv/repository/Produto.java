package br.com.eveoliv.repository;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
	public String toString() {

		return String.format("O produto cadastrado foi: %d %s %s", this.id, this.nome, this.descricao);
	}
}
