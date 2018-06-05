package p2b;

public class Barco {

	Pila[] pilas;
	
	public Barco(int cantidad) {
		      pilas = new Pila[cantidad];
		      for (int i = 0; i < pilas.length; i++) {
		    	  pilas[i] = new Pila(i + 1, 5);
			  }
		   }
	
}
