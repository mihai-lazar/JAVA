package exercise15;

public class Ex115 {
	
	int numerator;
	int denominator;
	
	public Ex115() {
		numerator = 0;
		denominator = 1;	
	}
	
	public Ex115(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;	
	}
	
	public void printRational() {
		System.out.println(numerator + "/" + denominator);
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public void invert() {
		int newNumerator = denominator;
		int newDenominator = numerator;
		numerator = newNumerator ;
		denominator = newDenominator;
	}
	
	public void negate() {
		numerator = numerator * -1;
	}
	
	public double toDouble() {
		double numerator = this.numerator;
		double denominator = this.denominator;
		return numerator/denominator;
	}
	
	public void reduce() {
		int gcd = gcd(numerator, denominator);
		System.out.println(numerator/gcd + "/" + denominator/gcd);
	}
	
	
	public static int gcd(int p, int q) {
		if (q == 0) {
	    	return p;
	    }
	        return gcd(q, p % q);
	}
	
	public Ex115 add(Ex115 numero) {
		int nuevoNumerador = numerator*numero.denominator + numero.numerator*denominator;
		int nuevoDenominador = denominator*numero.denominator;
		int gcd = gcd(nuevoNumerador, nuevoDenominador);
		
		return new Ex115(nuevoNumerador/gcd, nuevoDenominador/gcd);
	}
	
	
	public static void main(String[] args) 
	{
		Ex115 numero1 = new Ex115();		
		numero1.numerator = 5;
		numero1.denominator = 3;
		numero1.printRational();
		System.out.println(numero1.toString());
		
		Ex115 numero2 = new Ex115(10, 6);		
		numero2.printRational();
		numero2.negate();
		System.out.println(numero2.toString());
		
		numero2.invert();
		System.out.println(numero2.toString());
		numero2.invert();
		System.out.println(numero2.toDouble());
		
		numero1.reduce();
		numero2.reduce();
		
		System.out.println(numero1.add(numero1).toString());
	}
	

}
