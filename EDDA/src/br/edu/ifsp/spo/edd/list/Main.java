package br.edu.ifsp.spo.edd.list;

public class Main {

	public static void main(String[] args) {
		
		Lista<Integer> seq = new Lista<Integer>();
		for(int i = 0; i < 4; i++) {
			seq.adicionar(i);
		}
		
		System.out.println("A: " + seq);
		
		boolean buscaSequencial = seq.buscaSequencial(2);
		System.out.println("B: " + buscaSequencial);
		
		for(int i = 0; i < 4; i++) 
			seq.adicionar(i);
		
		
	}

}
