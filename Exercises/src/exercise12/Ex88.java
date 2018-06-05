package exercise12;

import java.util.Arrays;
import java.util.Random;

public class Ex88 {
	
	public static void main(String[] args) {
			
		
		//System.out.println(maxInRange(randomArray(Integer.parseInt(args[0])), Integer.parseInt(args[1]), Integer.parseInt(args[2])));		
		System.out.println(max(randomArray(Integer.parseInt(args[0]))));
		
	}
	
	
	public static int maxInRange(int[] numeros, int inf, int sup) {
		if(inf == sup)
			return numeros[inf - 1];
		else {
			int recursion = maxInRange(numeros, inf + 1, sup);		
			if(recursion >= numeros[inf - 1])
				return recursion;
			else
				return numeros[inf - 1];
		}
		
	}
	
	
	public static int max(int[] numeros) {
		return maxInRange(numeros, 1, numeros.length);		
	}
	
	
	public static int[] randomArray(int size) {
		Random random = new Random();
			int[] numeros = new int[size];
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = random.nextInt(100);
			}
	    System.out.println(Arrays.toString(numeros));
		return numeros;
	}

	
}
