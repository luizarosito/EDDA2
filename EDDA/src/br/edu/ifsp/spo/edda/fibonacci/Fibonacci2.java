package br.edu.ifsp.spo.edda.fibonacci;
public class Fibonacci2 {
	
	public static void main(String[] args) {
		int f0 = 0;
		int f1 = 1;
		int fn;
		
		for (int i = 0; i < 30; i++) {
			if (f0 < 100) {
				System.out.print(f0 + " ");
				fn = f0;
				f0 = f0 + f1;
				f1 = fn;
			}
			
		}
		
	}
	
}