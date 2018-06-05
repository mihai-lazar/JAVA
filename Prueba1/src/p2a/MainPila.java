/*
    El main al ser ejecutado, crea un objeto Pila con id 1 y 2 elementos, todos estos random
    despues agrego el numero 15, dejandolo de 3 elementos, despues saco el elemento top 3 veces
    la pila queda vacia y la 4 ves que intento me da el mensaje que no quedan mas elementos
    
    
    Este es el out put:
    
	[89, 26]  Pila(1, 2) Creo la pila
	[89, 26, 15] Pila.PilaPush(15); agrego el numero 15
	[89, 26]  Pila.PilaPop();	
	[89]  Pila.PilaPop();	
	[]  Pila.PilaPop();	
	Pila sin elementos
*/

package p2a;

import java.util.Arrays;

public class MainPila {
	
	public static void main(String[] args) {
		
		Pila Pila = new Pila(1, 2);
		System.out.println(Arrays.toString(Pila.elementos));
		Pila.PilaPush(15);
		System.out.println(Arrays.toString(Pila.elementos));
		Pila.PilaPop();	
		System.out.println(Arrays.toString(Pila.elementos));
		Pila.PilaPop();	
		System.out.println(Arrays.toString(Pila.elementos));	
		Pila.PilaPop();	
		System.out.println(Arrays.toString(Pila.elementos));
		Pila.PilaPop();	
	}

}
