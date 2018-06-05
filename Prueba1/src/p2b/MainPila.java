/*
    El main al ser ejecutado, crea un objeto barco el que crea 5 pilas y despues cada pila crea
    5 contenedores con id 1 2 3 4 5.
    
    5 System.out.println((newBarco.pilas[0].contenedores.length));
	p2b.Contenedor@70dea4e System.out.println((newBarco.pilas[0].contenedores[0]));
	1 System.out.println((newBarco.pilas[0].contenedores[0].id));
	2 System.out.println((newBarco.pilas[0].contenedores[1].id));
	3 System.out.println((newBarco.pilas[0].contenedores[2].id));
	5 System.out.println((newBarco.pilas[4].id));
	5 System.out.println((newBarco.pilas[4].contenedores[4].id));
*/


package p2b;

public class MainPila {
	
	public static void main(String[] args) {
		
		Barco newBarco = new Barco(5);

		System.out.println((newBarco.pilas[0].contenedores.length));
		System.out.println((newBarco.pilas[0].contenedores[0]));
		System.out.println((newBarco.pilas[0].contenedores[0].id));
		System.out.println((newBarco.pilas[0].contenedores[1].id));
		System.out.println((newBarco.pilas[0].contenedores[2].id));
		System.out.println((newBarco.pilas[4].id));
		System.out.println((newBarco.pilas[4].contenedores[4].id));
	}

}
