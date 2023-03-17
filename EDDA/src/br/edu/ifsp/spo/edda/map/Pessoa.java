package br.edu.ifsp.spo.edda.map;

public class Pessoa {
	
	private String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Pessoa: " + this.nome;
	}
	
}
