package br.edu.ifsp.spo.edda.matriz;
import java.util.Arrays;

public class Matriz1 {
	
	public static void main(String[] args) {
		int[][] matriz1 = new int[8][];
		int[] tamanhoLinhas = {9, 10, 6, 12, 6, 2, 1, 8};
		int valor = 0;
		for (int i = 0; i < tamanhoLinhas.length; i++) {
			int tamanhoLinha = tamanhoLinhas[i];
			matriz1[i] = new int[tamanhoLinha];
			for (int j = 0; j < tamanhoLinha; j ++) {
				matriz1[i][j] = ++valor;
			}
			
			System.out.println(Arrays.toString(matriz1[i]));
		}
	}
}
