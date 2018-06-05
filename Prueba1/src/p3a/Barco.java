package p3a;

import java.util.Random;

public class Barco {

	Pila[][] pilas = new Pila[10][10];
	
	public Barco(int cantidadP, int cantidadC) {
		for (int row = 0; row < 10; ++row) {
			for (int col = 0; col < 10; ++col) {
				pilas[row][col] = new Pila(1, 0);
		    }
		}
		
	    Random random = new Random();
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(1, cantidadC);
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(2, cantidadC);
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(3, cantidadC);
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(4, cantidadC);
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(5, cantidadC);
		pilas[random.nextInt(9)][random.nextInt(9)] = new Pila(6, cantidadC);
	}
	
	public void paint() {
		for (int row = 0; row < 10; ++row) {
			for (int col = 0; col < 10; ++col) {
				if(pilas[row][col] != null);
					pilas[row][col].paint();  
		       	}
			System.out.println();

		    }
		}
	
}
