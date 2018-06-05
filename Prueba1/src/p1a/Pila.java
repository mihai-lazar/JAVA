/*
    El main al ser ejecutado, crea un arreglo de ints de largo 4 con los elementos 15, 6, 2, 9, despues
    con PilaPush agrega el 15 y 22. Despues de eso con PilaPop, remueve todos los elementos hasta quedarse
    sin elementos y aparece el mensaje de Pila sin elementos al tratar de hacer PilaPop.
 
    Este es el out put:
    
  	[15, 6, 2, 9, 15]
	[15, 6, 2, 9, 15, 22]
	[15, 6, 2, 9, 15]
	[15, 6, 2, 9]
	[15, 6, 2]
	[15, 6]
	[15]
	[]
	Pila sin elementos
	[]
	Pila sin elementos
*/

package p1a;

import java.util.Arrays;

public class Pila {
	
	public static int[] PilaPush(int[] Pila, int X) {
		int[] NuevaPila = new int[Pila.length + 1];
		for(int i = 0 ; i < Pila.length ; i++) 
			NuevaPila[i] = Pila[i];
		NuevaPila[Pila.length] = X;
		return NuevaPila;
	}
	
	public static int[] PilaPop(int[] Pila) {
		if(PilaEmpty(Pila) == false) {
			int[] NuevaPila = new int[Pila.length - 1];
			for(int i = 0 ; i < Pila.length - 1; i++) 
				NuevaPila[i] = Pila[i];
			return NuevaPila;
		}else {
			System.out.println("Pila sin elementos");
			return Pila;
		}	
	}
	
	public static boolean PilaEmpty(int[] Pila) {
		if(Pila.length == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		int[] Pila = new int[4];
		Pila[0] = 15;
		Pila[1] = 6;
		Pila[2] = 2;
		Pila[3] = 9;
		
		Pila = PilaPush(Pila, 15);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPush(Pila, 22);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);
		System.out.println(Arrays.toString(Pila));
		Pila = PilaPop(Pila);	
		
	}

	
	
}
