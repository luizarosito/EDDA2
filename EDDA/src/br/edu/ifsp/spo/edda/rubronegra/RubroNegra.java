package br.edu.ifsp.spo.edda.rubronegra;

import br.edu.ifsp.spo.edu.arvore.BuscaBinaria;

public class RubroNegra {
	
	No raiz;
	No nulo;
	
	public RubroNegra() {
		nulo = new No();
		
		raiz = nulo;
	}
	
	void rotacaoEsq(No x) {
		No y = x.direita;
		
		x.direita = y.esquerda;
		if(y.esquerda != nulo) {
			y.esquerda.pai = x;
		}
		
		y.pai = x.pai;
		
		if(x.pai == nulo) { 
			raiz = y;
		}else {
			if(x == x.pai.esquerda) {
				x.pai.esquerda = y;
			}else {
				x.pai.direita = y;
			}
		}
		
		y.esquerda = x;
		x.pai = y;
	}
	
	void rotacaoDir(No y) {
		No x = y.esquerda;
		
		y.esquerda = x.direita;
		if(x.direita != nulo) {
			x.direita.pai = y;
		}
		
		x.pai = y.pai;
		if(y.pai == nulo) {
			raiz = x;
		}else {
			if(y == y.pai.esquerda) {
				y.pai.esquerda = x;
			}else {
				y.pai.direita = x;
			}
		}
		
		x.direita = y;
		y.pai = x;
	}
	
	void inserir(int elemento) {
		No anterior, p;
		anterior = nulo;
		p = raiz;
		
		while(p != nulo) {
			anterior = p;
			if(elemento < p.elemento) {
				p = p.esquerda;
			}else if (elemento > p.elemento) {
				p = p.direita;
			}else if(elemento == p.elemento) {
				return;
			}
		}
		
		No novo = new No(elemento);
		novo.pai = anterior;
		novo.esquerda = novo.direita = nulo;
		novo.cor = Cor.vermelho;
		
		if(raiz == nulo) {
			raiz = novo;
		}else {
			if(elemento < anterior.elemento) {
				anterior.esquerda = novo;
			} else {
				anterior.direita = novo;
			}
		}
		
		RestaurarRB(novo);
		
	}
	
	void RestaurarRB(No x) {
		No y;
		
		while(x.pai.cor == Cor.vermelho) {
			if(x.pai == x.pai.pai.esquerda) {
				y = x.pai.pai.direita;
				
				if(y.cor == Cor.vermelho) {
					y.cor = Cor.preto;
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					x = x.pai.pai;
				}else {
					
					if(x == x.pai.direita) {
						x = x.pai;
						rotacaoEsq(x);
					}
					
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					rotacaoDir(x.pai.pai);
				}
				
			} else {
				y = x.pai.pai.esquerda;
				if(y.cor == Cor.vermelho) {
					y.cor = Cor.preto;
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					x = x.pai.pai;
				}else {
					if(x == x.pai.esquerda) {
						x = x.pai;
						rotacaoDir(x);
					}
					x.pai.cor = Cor.preto;
					x.pai.pai.cor = Cor.vermelho;
					rotacaoEsq(x.pai.pai);
				}
			}
		}
		raiz.cor = Cor.preto;
	}
		
		
	void mostrar() {
			ordem(raiz, "    ");
		}
		
		void ordem(No p, String espaco) {
			if(p != nulo) {
				ordem(p.esquerda, "    " + espaco);
				System.out.println(espaco + p.elemento);
				ordem(p.direita, "    " + espaco);
			}
		}
		
		
		
		boolean busca(No r, int elemento) {
			boolean ret = false;
			
			while((r != nulo) && !ret) {
				int val = r.elemento;
				if(elemento < val) {
					r = r.esquerda;
				}else if(elemento < val) {
					r = r.direita;
				}else {
					ret = true;
					break;
				}
				ret = busca(r, elemento);
					
			}
			return ret;	
		}
	
}
