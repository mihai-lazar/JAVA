package Ejercicios;
import java.util.Random;
import java.util.Scanner;

public class Ej3_4_V2 
{
	private static Scanner in;
	
	public static int ingresoNumero()
	{
		Random random = new Random();
		int NumeroRandom = random.nextInt(100) + 1;
		//int NumeroRandom = (int)(100*Math.random()) + 1;
		
		System.out.println(NumeroRandom);
		System.out.println("I'm thinking of a number between 1 and 100\n(including both). Can you guess what it is?");
		int Numero;
		
		in = new Scanner(System.in);
		Numero = checkNumero();
		
		System.out.println("Your guess is: " + Numero);
		System.out.println("The number I was thinking of is: " + NumeroRandom);
		
		if(Numero == NumeroRandom)
			System.out.println("Congratulations you guessed it!\n");
	    else
	    	System.out.println("You were off by: " + Math.abs(Numero - NumeroRandom) + "\n");
		
		return ingresoNumero();
	}
	
	public static int checkNumero()
	{
		System.out.print("Type a number: ");
		String Ingresado = in.nextLine();
		int Numero;
		
		try 
		{
			Integer.parseInt(Ingresado);
			Numero = Integer.parseInt(Ingresado);
		}catch(NumberFormatException e) 
		{
			System.out.print("That's not a number, try again\n");
			return checkNumero(); 
	    }
		
		if(Numero > 0 && Numero < 101)
			return Numero;
		else
			System.out.print("Number out of limits, try again\n");
			return checkNumero();
	}

	public static void main(String[] args) 
	{
		ingresoNumero();
	}
	
}