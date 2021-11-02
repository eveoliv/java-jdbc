package br.com.eveoliv.repository.model;

public class Categoria {

	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria(Integer id, String nome) {	
		this.id = id;
		this.nome = nome;
	}
	
	
}
