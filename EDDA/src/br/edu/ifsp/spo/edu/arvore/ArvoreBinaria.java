package br.edu.ifsp.spo.edu.arvore;

public class ArvoreBinaria{
	
	ArvoreBinaria r;
	ArvoreBinaria esquerda;
	ArvoreBinaria direita;
	int valor;
	
	//apostila, computar profundidade nodo
//	int profundidade(ArvoreBinaria n) {
//		int d = 0;
//		while (n != r) {
//			n = n.valor;
//			d++;
//			}
//			return d;
//	}
	
	// apostila, visitar os nos da arvore
	void traverse(ArvoreBinaria n) {
		if (n == null) return;
		traverse(n.esquerda);
		traverse(n.direita);
		}
	
	//Criar no
	ArvoreBinaria(int valor, ArvoreBinaria esquerda, ArvoreBinaria direita) {
		this.valor = valor;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	void preOrdem(ArvoreBinaria n) {
		System.out.println(n.valor);
		if(n.esquerda != null) {
			preOrdem(n.esquerda);
		}
		if(n.direita != null) {
			preOrdem(n.direita);
		}
	}
	
	void emOrdem(ArvoreBinaria n) {
		if(n.esquerda != null) {
			emOrdem(n.esquerda);
		}
		System.out.println(n.valor);
		if(n.direita != null) {
			emOrdem(n.direita);
		}
	}
	
	void posOrdem(ArvoreBinaria n) {
		if(n.esquerda != null) {
			posOrdem(n.esquerda);
		}
		if(n.direita != null) {
			posOrdem(n.direita);
		}
		System.out.println(n.valor);
	}
	
	boolean busca(BuscaBinaria arvore, int valor) {
		boolean ret = false;
		
		if(arvore == null) {
			ret = false;
			
		}else if(arvore.valor == valor) {
			ret = true;
			
		}else {
			
			if(arvore.valor > valor) {
				ret = busca(arvore.esquerda, valor);
			} else {
				ret = busca(arvore.direita, valor);
			}
		}
		return true;
	}
	
}
