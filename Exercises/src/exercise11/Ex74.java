package exercise11;

public class Ex74 {
	
	public static void main(String[] args) {
		
		int factorial = Integer.parseInt(args[0]);
		
		System.out.println(fac(factorial));
		
	}
	
	public static int fac(int n) {
		
		int resultado = 1;
		for(int i = 1 ; i <= n ; i++) {
			resultado = i * resultado;
		}			
		return resultado;	
	}
	
	
	/*
	public static int fac(int n) {
		if (n == 0) {
			return 1;
		} else {
			int recurse = fac(n - 1);
			int result = n * recurse;
			return result;
		}
	}	
	*/

}
