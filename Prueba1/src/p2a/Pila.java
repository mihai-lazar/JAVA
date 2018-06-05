package p2a;

import java.util.Random;

public class Pila {
	
	int id;
	int[] elementos;
	
	public Pila(int id, int cantidad) {
		      this.id = id;
		      elementos = new int[cantidad];
		      Random random = new Random();
		      for (int i = 0; i < elementos.length; i++) {
		    	  elementos[i] = random.nextInt(100);
			  }
		   }
	
	public void PilaPush(int X) {
		int[] nuevosElementos = new int[elementos.length + 1];
		for(int i = 0 ; i < elementos.length ; i++) 
			nuevosElementos[i] = elementos[i];
		nuevosElementos[nuevosElementos.length-1] = X;
		elementos = nuevosElementos;
	}
	
	public void PilaPop() {
		if(PilaEmpty(elementos) == false) {
			int[] nuevosElementos = new int[elementos.length - 1];
			for(int i = 0 ; i < elementos.length - 1; i++) 
				nuevosElementos[i] = elementos[i];
			elementos = nuevosElementos;
		}else {
			System.out.println("Pila sin elementos");
		}	
	}
	
	public static boolean PilaEmpty(int[] elem) {
		if(elem.length == 0)
			return true;
		else
			return false;
	}
		
	
}
