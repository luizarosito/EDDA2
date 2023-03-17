package br.edu.ifsp.spo.edu.arvore;

public class BuscaBinaria {
	BuscaBinaria esquerda;
	BuscaBinaria direita;
	int valor;
	
	BuscaBinaria(int valor) {
		this.valor = valor;
		this.esquerda = null;
		this.direita = null;
	}
	
	void montaArvore(BuscaBinaria novo, BuscaBinaria arvore) {
		
		if(arvore == null) {
			arvore = novo;
		}else {
			
			if(novo.valor < arvore.valor) {
				
				if(arvore.esquerda == null) {
					arvore.esquerda = novo;
				}else {
					montaArvore(novo, arvore.esquerda);
				}
				
			}else {
				if(arvore.direita == null) {
					arvore.direita = novo;
				}else {
					montaArvore(novo, arvore.direita);
				} 
				
			}
		}
	}
	
	static boolean busca(BuscaBinaria arvore, int valor) {
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
	
	void remover(BuscaBinaria arvore, int valor) {
		if(arvore.valor == valor) {
			arvore = null;
		}else if(arvore.valor > valor) {
			if((arvore.esquerda.valor == valor)) {
				estrategiaRemoverEsquerda(arvore);
			}else {
				remover(arvore.esquerda, valor);
			}
		} else {
			if((arvore.direita.valor == valor)) {
				estrategiaRemoverDireita(arvore);
			}else {
				remover(arvore.direita, valor);
			}
		}
	}
	
	void estrategiaRemoverEsquerda(BuscaBinaria noPai) {
		
	}
	
	void estrategiaRemoverDireita(BuscaBinaria noPai) {
		
	}
	
	
	
}
