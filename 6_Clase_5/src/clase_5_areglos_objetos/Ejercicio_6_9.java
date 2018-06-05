package clase_5_areglos_objetos;

public class Ejercicio_6_9 {
	
	public static void main(String[] args) {
		
		double numero = (double)Integer.parseInt(args[0]);
		int potencia = Integer.parseInt(args[1]);
		
		System.out.println(power(numero, potencia));
		
	}
	
	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			double recurse = power(x, n - 1);
			double result = x * recurse;
			return result;
		}
	}

}
