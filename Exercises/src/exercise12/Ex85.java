package exercise12;

public class Ex85 {
	
	public static void main(String[] args) {
		
		int limite = Integer.parseInt(args[0]);		
		
		int [] numeros = new int[limite];                  
		for (int a = 0; a < numeros.length; a++) {
			numeros[a] = a + 2;
		}
		
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] != 0) {
				for(int e = i + 1 ; e < numeros.length; e++) {
					if(numeros[e]%numeros[i] == 0) {
						numeros[e] = 0;
					}
				}
			System.out.println(numeros[i]);	
			}
		}	
		
	}

}
