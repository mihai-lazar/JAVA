package exercise11;

public class Ex73 {
	
	public static void main(String[] args) {
		
		double numero = (double)Integer.parseInt(args[0]);
		int potencia = Integer.parseInt(args[1]);
		
		System.out.println(power(numero, potencia));
		
	}
	
	public static double power(double x, int n) {
		
		double result = x;
		for(int i = 0 ; i < n - 1 ; i++) {
			result = x * result;
		}
			return result;
		
	}
	
	/*
	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			double recurse = power(x, n - 1);
			double result = x * recurse;
			return result;
		}
	}
	*/

}
