package exercise14;

import java.math.BigInteger;

public class Ex104 {
	
	public static void main(String[] args) {
		
		int factorial = Integer.parseInt(args[0]);
		
		fac(factorial);
		
	}
	
	public static void fac(int n) {
		
		BigInteger resultado = BigInteger.valueOf(1);
		for(int i = 1 ; i <= n ; i++) {
			resultado = resultado.multiply(BigInteger.valueOf(i));
			System.out.println(i + ", " + resultado);
		}	
	}
	
	//it is because of the limit of the primitive class int
	//Is immutable
	
	
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
