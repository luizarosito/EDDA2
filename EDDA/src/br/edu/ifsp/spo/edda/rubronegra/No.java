package br.edu.ifsp.spo.edda.rubronegra;

public class No {

	int elemento;
	No esquerda, direita, pai;
	Cor cor;
	
	public No() {
		elemento = 0;
		esquerda = direita = pai = null;
		cor = Cor.preto;
	}
	
	public No(int elemento) {
		this.elemento = elemento;
		esquerda = direita = pai = null;
		cor = Cor.preto;
	}
}
