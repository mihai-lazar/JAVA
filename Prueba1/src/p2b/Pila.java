package p2b;

public class Pila {
	
	int id;
	Contenedor[] contenedores;
	
	public Pila(int id, int cantidad) {
		      this.id = id;
		      contenedores = new Contenedor[cantidad];
		      for (int i = 0; i < contenedores.length; i++) {
		    	  contenedores[i] = new Contenedor(i + 1);
			  }
		   }
	
	public void PilaPush() {
		Contenedor nuevoContenedor = new Contenedor(contenedores.length + 1);	
		Contenedor[] nuevosContenedores = new Contenedor[contenedores.length + 1];
		for(int i = 0 ; i < contenedores.length ; i++) 
			nuevosContenedores[i] = contenedores[i];
		nuevosContenedores[nuevosContenedores.length-1] = nuevoContenedor;
		contenedores = nuevosContenedores;
	}
	
	public void PilaPop() {
		if(PilaEmpty(contenedores) == false) {
			Contenedor[] nuevosContenedores = new Contenedor[contenedores.length - 1];
			for(int i = 0 ; i < contenedores.length - 1; i++) 
				nuevosContenedores[i] = contenedores[i];
			contenedores = nuevosContenedores;
		}else {
			System.out.println("Pila sin elementos");
		}	
	}
	
	public static boolean PilaEmpty(Contenedor[] elem) {
		if(elem.length == 0)
			return true;
		else
			return false;
	}
		
	
}
