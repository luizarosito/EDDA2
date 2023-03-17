package br.edu.ifsp.spo.edda.map;

public class Associacao {
	
	private String cpf;
	private Pessoa pessoa;
	
	public Associacao(String cpf, Pessoa pessoa) {
		this.cpf = cpf;
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public String getCpf() {
		return cpf;
	}
	
}
