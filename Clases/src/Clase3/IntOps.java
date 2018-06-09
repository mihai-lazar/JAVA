package Clase3;

public class IntOps 
{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int sum = a + b;
		int prod = a * b;
		int quot = 0;
		int rem = 0;
		if(b != 0) 
		{
			quot = a / b;
		    rem = a % b;
		}
		System.out.println(a + "+" + b +"=" + sum);
		System.out.println(a + "*" + b +"=" + prod);
		if(b != 0)
			System.out.println(a + "/" + b +"=" + quot);
		else
			System.out.println("No se puede dividir por 0");
		System.out.println(a + "%" + b +"=" + rem);
	}

}
