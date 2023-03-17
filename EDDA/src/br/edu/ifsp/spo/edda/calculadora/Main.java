package br.edu.ifsp.spo.edda.calculadora;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.dividir(20, 5, 2));
	}
}
