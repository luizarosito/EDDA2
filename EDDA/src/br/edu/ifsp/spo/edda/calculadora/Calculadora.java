package br.edu.ifsp.spo.edda.calculadora;

public class Calculadora {
	
	public static double somar(double numero1, double numero2) {
		double value = numero1 + numero2;
		return value;
	}
	
	public static double somar(double... numeros) {
		double value = 0;
		for (int i = 0; i < numeros.length; i++) {
			double n = numeros[i];
			value += n;
		}
		return value;
		
	}
	
	public static double subtrair(double numero1, double numero2) {
		double value = numero1 - numero2;
		return value;
	}
	
	public static double subtrair(double... numeros) {
		double value = 0;
		for (int i = 0; i < numeros.length; i++) {
			double n = numeros[i];
			if (i == 0) {
				value = n;
			} else {
				value -= n;
			}
		}
		return value;
	}
	
	public static double multiplicar(double numero1,double numero2) {
		return numero1 * numero2;
	}
	
	public static double multiplicar(double... numeros) {
		double value = 0;
		for (int i = 0; i < numeros.length; i++) {
			double n = numeros[i];
			if (i == 0) {
				value = n;
			} else {
				value *= n;
			}
		}
		return value;
	}
	
	public static double dividir(double numero1, double numero2) {
		return numero1 / numero2;
	}
	
	public static double dividir(double... numeros) {
		double value = 0;
		for (int i = 0; i < numeros.length; i++) {
			double n = numeros[i];
			if (i == 0) {
				value = n;
			} else {
				value /= n;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println(dividir(12, 5, 2));
		
	}
}
