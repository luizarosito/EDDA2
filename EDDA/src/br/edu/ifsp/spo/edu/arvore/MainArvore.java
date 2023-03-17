package br.edu.ifsp.spo.edu.arvore;

public class MainArvore {

	public static void main(String[] args) {

		ArvoreBinaria no = new ArvoreBinaria(15, new ArvoreBinaria(10, null, null), new ArvoreBinaria(50, new ArvoreBinaria(20, null, null), null));
		
		System.out.println("Pré-ordem:");
		no.preOrdem(no);
		System.out.println(" ");
		
		System.out.println("Em-ordem:");
		no.emOrdem(no);
		System.out.println(" ");
		
		System.out.println("Pós-ordem:");
		no.posOrdem(no);
		System.out.println(" ");
		
		System.out.println("Busca binária");
		System.out.println(no.busca(null, 8));
		  
	}

}
