package p3b;

import java.util.Random;

public class Barco {

	Pila[][] pilas = new Pila[10][10];
	
	public Barco(int cantidadP, int cantidadC) {
		for (int row = 0; row < 10; ++row) {
			for (int col = 0; col < 10; ++col) {
				pilas[row][col] = new Pila(0, 0);
		    }
		}
		
	    Random random = new Random();
	    for (int i = 0; i < cantidadP; ++i) {
	    	int row = 0;
	    	int col = 0;
	    	int o = 1;
	    	while(o == 1) {
	    		row = random.nextInt(9);
	    		col = random.nextInt(9);		
	    		if(pilas[row][col].id == 0)
	    			o = 0;
	    	}	
	    	pilas[row][col] = new Pila(i, cantidadC);
	    }
	}
	
	public void paint() {
		for (int row = 0; row < 10; ++row) {
			for (int col = 0; col < 10; ++col) {
					pilas[row][col].paint();  
		       	}
			System.out.println();

		    }
		}
	
}
