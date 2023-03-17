package br.edu.ifsp.spo.edda.map;

public class Main {

	public static void main(String[] args) {
		
		Mapa mapaLista = new Mapa();
		int numeroDeElementos = 15000;

		long inicio = System.currentTimeMillis();

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.insere("" + i, new Pessoa("p" + i));
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.seleciona("" + i);
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.contemChave("" + i);
		}

		for (int i = 0; i < numeroDeElementos; i++) {
			mapaLista.remover("" + i);
		}

		long fim = System.currentTimeMillis();

		System.out.println("Tempo: " + (fim - inicio) / 1000.0);
		
	}

}
