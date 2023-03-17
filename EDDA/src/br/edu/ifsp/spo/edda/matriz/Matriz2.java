package br.edu.ifsp.spo.edda.matriz;
import java.util.Arrays;
	
public class Matriz2 {
		
	public static void main(String[] args) {
		int[][] meses = new int[12][];
		meses[0] = new int[31];
		meses[1] = new int[28];
		meses[2] = new int[31];
		System.out.println("null");
		int[] tamanhoLinhas = {1, 2, 3, 4, 5, 6, 7};
		int valor = 0;
		for (int i = 0; i < tamanhoLinhas.length; i++) {
			int tamanhoLinha = tamanhoLinhas[i];
			meses[i] = new int[tamanhoLinha];
			for (int j = 0; j < tamanhoLinha; j ++) {
				meses[i][j] = ++valor;
			}
				
			System.out.println(Arrays.toString(meses[i]));
		}
	}
}
