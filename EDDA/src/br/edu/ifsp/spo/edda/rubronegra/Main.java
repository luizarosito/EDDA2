package br.edu.ifsp.spo.edda.rubronegra;

public class Main {

	public static void main(String[] args) {

		RubroNegra arvore = new RubroNegra();
		
		arvore.inserir(34);
		arvore.inserir(3);
		arvore.inserir(50);
		arvore.inserir(20);
		arvore.inserir(15);
		arvore.inserir(16);
		arvore.inserir(25);
		arvore.inserir(27);
		arvore.mostrar();
		
		System.out.println("Busca binária");
		System.out.println(arvore.busca(null, 8));
	}

}
