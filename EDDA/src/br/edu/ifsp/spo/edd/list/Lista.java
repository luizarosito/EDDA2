package br.edu.ifsp.spo.edd.list;

import java.util.Arrays;
import java.util.Comparator;


public class Lista<TipoGenerico extends Comparable<TipoGenerico>> {
	
	@SuppressWarnings("unused")
	private Comparable[] valores;
	private int quantidadeElementos;

	public Lista() {
		this.valores = new Comparable[10];
	}

	public Lista(int tamanho) {
		this.valores = new Comparable[tamanho];
	}

	public void adicionar(TipoGenerico valor) {
		if (quantidadeElementos >= valores.length) {
			aumentarTamanho();
		}
		this.valores[quantidadeElementos++] = valor;
	}

	private void aumentarTamanho() {
		Comparable[] novoArray = new Comparable[2 * valores.length];
		for (int i = 0; i < valores.length; i++) {
			novoArray[i] = valores[i];
		}
		valores = novoArray;
	}

	public void adicionar(TipoGenerico valor, int posicao) {
		while (valores.length <= posicao) {
			aumentarTamanho();
		}
		insereValor(valor, posicao);
	}

	private void insereValor(TipoGenerico valor, int posicao) {

		if (valores[posicao] == null) {
			valores[posicao] = valor;
			quantidadeElementos = posicao + 1;
		} else {
			Comparable valorNovo = valor;
			Comparable valorAntigo = null;
			for (int i = posicao; i < valores.length; i++) {
				valorAntigo = valores[i];
				valores[i] = valorNovo;
				valorNovo = valorAntigo;
			}
//			quantidadeElementos = valores.length;
			adicionar((TipoGenerico) valorNovo);
		}
		
		bubbleSort();

	}

	private boolean isPosicaoValida(int posicao) {
		return posicao > -1 && posicao < valores.length;
	}

	public TipoGenerico get(int posicao) {

		TipoGenerico valor = null;
		if (isPosicaoValida(posicao)) {
			valor = (TipoGenerico) valores[posicao];
		}
		return valor;
	}

	public boolean isEmpty() {
		return quantidadeElementos > 0;
	}

	public int size() {
		return quantidadeElementos;
	}

	public void set(int valor, int posicao) {
		if (isPosicaoValida(posicao)) {
			valores[posicao] = valor;
		}
	}

	public TipoGenerico remover() {

		TipoGenerico valor = null;
		if (quantidadeElementos > 0) {
			valor = (TipoGenerico) valores[--quantidadeElementos];
		}
		return valor;
	}

	public void bubbleSort() {
		Comparable aux;
		for (int j = 0; j < quantidadeElementos - 1; j++) {
			for (int i = 0; i < quantidadeElementos - 1 - j; i++) {
				System.out.println("Comparando " + valores[i] + " com " +valores[i + 1]);
				if (valores[i].compareTo(valores[i + 1]) == 1) {
					System.out.println("->empurra " + valores[i] + " para o fundo");
					System.out.println("-> troca com " + valores[i + 1]);
					aux = valores[i];
					valores[i] = valores[i + 1];
					valores[i + 1] = aux;
				}
			}
		}
		toString();
	}
	
	public void selectionSort() {
		
		int s = quantidadeElementos;

		for(int i = 0; i < s - 1; i++){
			int minimo = i;
			for (int j = i + 1; j < s; j++) {
				//if (v[j] < v[min])
				if (valores[j].compareTo(valores[minimo]) >= 1) {
					minimo = j;
				}
				
				Comparable<Number> menorN = valores[minimo];
				valores[minimo] = valores[i]; 
	            valores[i] = menorN; 
			}
		}
	}
	
	public void insertSort() {
		
		int s = quantidadeElementos;
		
		for (int i = 1; i < quantidadeElementos; i++) {
			Comparable<?> aux = valores[i];
			int anterior = i - 1;
			//while ((j > 0) && (v[j-1] > temp))
			while ( (anterior >= 0) && (valores[anterior].compareTo(aux) == 1)) {
				valores[anterior + 1] = valores[anterior];
				anterior--;
			}
			valores[anterior + 1] = aux;
		}
		//toString();
	}
	
	private void quickSort(Comparable[] valores, Integer inicio, Integer fim) {
		if(fim > inicio) {
			Integer indexPivo = dividir(valores, inicio, fim);
			quickSort(valores, inicio, indexPivo - 1);
			quickSort(valores, indexPivo + 1, fim);
	    }
	}

	private Integer dividir(Comparable[] valores, Integer inicio, Integer fim) {
		Comparable pivo;
	    Integer pontEsq, pontDir = fim;
	    pontEsq = inicio + 1;
	    pivo = valores[inicio];

	    while(pontEsq.compareTo(pontDir)>=1) {
	    	while(pontEsq.compareTo(pontDir) >=1 && valores[pontEsq].compareTo(pivo)>=1) {
	    		pontEsq++;
	    	}
	    	
	    	while(pontDir.compareTo(pontEsq)<=1 && valores[pontDir].compareTo(pivo)<1) {
	    		pontDir--;
	    	}

	    	if(pontEsq < pontDir) {
	    		trocar(valores, pontDir, pontEsq);
	    		pontEsq++;
	    		pontDir--;
	    	}
	    }
	    trocar(valores, inicio, pontDir);
	    return pontDir;
	 }

	private void trocar(Comparable[] valores, Integer i, Integer j) {
		Comparable temp = valores[i];
		valores[i] = valores[j];
		valores[j] = temp;
	}
	
	public void mergeSort() {
		
	    Integer elementos = 1;
	    Integer inicio=0, meio, fim;
	    
	    while(elementos < valores.length ) {
	      while(inicio + elementos < valores.length) {
	        meio = inicio + elementos;
	        fim = inicio + 2 * elementos;
	        if(fim.compareTo(quantidadeElementos)>=1) {
	        	fim = valores.length;
	        }
	        
	        intercala(valores, inicio, meio, fim);
	        inicio = fim;
	      }
	      elementos = elementos * 2;
	    }
	  }
	
	public void intercala(Comparable[] valores, Integer inicio, Integer meio, Integer fim) {
		Comparable[] novoVetor = new Integer[fim - inicio];
	    Integer i = inicio;
	    Integer m = meio;
	    Integer pos = 0;
	    
	    while(i < meio && m < fim) {
	      if(valores[i].compareTo(valores[m])>=1) {
	        novoVetor[pos] = valores[i];
	        pos = pos + 1;
	        i = i + 1;
	      } else {
	        novoVetor[pos] = valores[m];
	        pos = pos + 1;
	        m = m + 1;
	      }
	    }
	    while(i < meio) {
	      novoVetor[pos] = valores[i];
	      pos = pos + 1;
	      i = i + 1;
	    }
	    while(m < fim) {
	      novoVetor[pos] = valores[m];
	      pos = pos + 1;
	      m = m + 1;
	    }
	    for(pos = 0, i = inicio; i < fim; i++, pos++) {
	      valores[i] = novoVetor[pos];
	    }
	  }
	
	public void ordenarVetorDeInteiros(Comparable[] valores) {
	    quickSort(valores, 0, valores.length - 1);
	}
	
	public class Heapsort {
		public Integer tam;
		public Comparable[] vetor;
		    
		public  void heapsort() {
			vetor = valores;         
		    tam = vetor.length - 1;   
		    constroiHeap();
		        
		    for (Integer i = tam; i > 0; i--) {
		    	troca(0, tam);      
		        tam -= 1;           
		        maxHeapifica(0);  
		    }
		 }
		    
		public void constroiHeap() {
			Integer meio = (Integer) (tam/2);
			for (Integer i = meio - 1; i >= 0; i--) {
				maxHeapifica(i);
		    }
		}
		    
		public void troca(Integer i, Integer j) {
			Comparable aux;
		    aux = vetor[i];
		    vetor[i] = vetor[j];
		    vetor[j] = aux;
		}
		    
		public void maxHeapifica(Integer pai) {
			Integer maior = pai, esquerda = 2 * pai + 1, direita = 2 * pai + 2;
			if (esquerda.compareTo(tam)>=1 && vetor[esquerda].compareTo(vetor[maior])<1) {
				maior = esquerda;
		    }
		    if (direita.compareTo(tam)>=1 && vetor[direita].compareTo(vetor[maior])<1) {
		    	maior = direita;
		    }
		    if (maior != pai) {
		    	troca(pai, maior);     
		       	maxHeapifica(maior);  
		    }
		}
	}

	public boolean buscaSequencial(TipoGenerico valor) {
	    for(int i = 0; i < valores.length; i++) {
	      if (valores[i].compareTo(valor) == 0) {
	    	return true;
	      }
	    }   
		return false;
	 }
	
	
	public boolean buscaBinaria(TipoGenerico valor, Integer x) {
		 int meio;
		 int inicio = 0;
		 int fim = valores.length - 1;
		 
		 while (inicio <= fim) {
			 meio = (inicio + fim) / 2;
			 if (valores[meio] == x) 
				 return true; //meio
			 
			 else if (valores[meio].compareTo(valor) < x) inicio = meio + 1; 
			 else if (valores[meio].compareTo(valor) > x) fim = meio - 1; 
		 }	 
		 return false; //-1
	}

	@Override
	public String toString() {
		String meusValores = "{ ";
		for (int i = 0; i < quantidadeElementos; i++) {
			Object object = valores[i];
//			if (object != null) {
				meusValores += object + " ";
//			}
		}
		meusValores += "}";
		return meusValores;
	}
}
