/*
    El main al ser ejecutado, crea un arreglo de ints de largo random con puros elementos random despues
    crea otro areglo de largo 20-el primer areglo y lo llena de elemtos random, despues junta estos dos
    arreglos en un nuevo areglo. Para eliminar o agregar un elemento se agrego C, que representa que pila
    es 1 o 2 en este caso y se le va quitando o agregando acordemente
 
    Este es el out put (todos los numeros son random asi que varian):
    
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 3, 20] Primer areglo
	[10, 10, 60, 23, 61] Segundo areglo
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 3, 20, 10, 10, 60, 23, 61] Se ven los dos areglos juntos
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 3, 20, 151, 10, 10, 60, 23, 61] PilaPush(pila, 151, 1), Se agrega el 151
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 3, 20, 10, 10, 60, 23, 61] PilaPop(pila, 1); Se quita el numero 151
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 3, 10, 10, 60, 23, 61] PilaPop(pila, 1); Se quita el numero 20
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 10, 10, 60, 23, 61] PilaPop(pila, 1); Se quita el numero 3
	[73, 45, 75, 42, 55, 42, 65, 81, 17, 76, 8, 5, 59, 10, 10, 60, 23] PilaPop(pila, 2); Se quita el numero 61
*/

package p1b;

import java.util.Arrays;
import java.util.Random;

public class PilayPila2 {
	
		static int[] pila;
		static int[] pila2;
		
		public static int[] PilaPush(int[] Pila, int X, int C) {			
			int[] NuevaPila = new int[Pila.length + 1];
			for(int i = 0 ; i < Pila.length ; i++) 
				NuevaPila[i] = Pila[i];
			NuevaPila[Pila.length] = X;
			
			if(C == 1) {
				pila = NuevaPila;
			}else if(C == 2) {
				pila2 = NuevaPila;
			}
			
			int[] conjuntoPilas = new int[pila.length + pila2.length];
			for (int i = 0; i < conjuntoPilas.length; i++) {
				if(i < pila.length)
					conjuntoPilas[i] = pila[i];
				else
					conjuntoPilas[i] = pila2[i - pila.length];
			}		
			return conjuntoPilas;
		}
		
		public static int[] PilaPop(int[] Pila, int C) {			
			if(PilaEmpty(Pila, C) == false) {
				int[] NuevaPila = new int[Pila.length - 1];
				for(int i = 0 ; i < Pila.length - 1; i++) 
					NuevaPila[i] = Pila[i];
				
				if(C == 1) {
					pila = NuevaPila;
				}else if(C == 2) {
					pila2 = NuevaPila;
				}
				
				int[] conjuntoPilas = new int[pila.length + pila2.length];
				for (int i = 0; i < conjuntoPilas.length; i++) {
					if(i < pila.length)
						conjuntoPilas[i] = pila[i];
					else
						conjuntoPilas[i] = pila2[i - pila.length];
				}		
				return conjuntoPilas;
			}else {
				System.out.println("Pila sin elementos");
				return Pila;
			}	
		}
		
		public static boolean PilaEmpty(int[] Pila, int C) {
			if(Pila.length == 0)
				return true;
			else
				return false;
		}
		
		public static void main(String[] args) {
			
			Random random = new Random();
			pila = new int[random.nextInt(19) + 1];
			for (int i = 0; i < pila.length; i++) {
				pila[i] = random.nextInt(100);
			}
			
			pila2 = new int[20 - pila.length];
			for (int i = 0; i < pila2.length; i++) {
				pila2[i] = random.nextInt(100);
			}
			
			int[] conjuntoPilas = new int[20];
			for (int i = 0; i < conjuntoPilas.length; i++) {
				if(i < pila.length)
					conjuntoPilas[i] = pila[i];
				else
					conjuntoPilas[i] = pila2[i - pila.length];
			}					
			
			System.out.println(Arrays.toString(pila));
			System.out.println(Arrays.toString(pila2));
			System.out.println(Arrays.toString(conjuntoPilas));
			conjuntoPilas = PilaPush(pila, 151, 1);
			System.out.println(Arrays.toString(conjuntoPilas));
			conjuntoPilas = PilaPop(pila, 1);
			System.out.println(Arrays.toString(conjuntoPilas));
			conjuntoPilas = PilaPop(pila, 1);
			System.out.println(Arrays.toString(conjuntoPilas));
			conjuntoPilas = PilaPop(pila, 1);
			System.out.println(Arrays.toString(conjuntoPilas));
			conjuntoPilas = PilaPop(pila2, 2);
			System.out.println(Arrays.toString(conjuntoPilas));

		}

}
