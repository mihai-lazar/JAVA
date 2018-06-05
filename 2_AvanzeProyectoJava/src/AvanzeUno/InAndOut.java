package AvanzeUno;
import java.util.Objects;
import java.util.Scanner;


public class InAndOut
{
	public static void main(String[] args) 
	{
		String line;
	   	System.out.print("ESTADO: ");
		line = extracted().nextLine();
		
		if(Objects.equals("OCUPADO", line)) 
		{
			for(int i = 0; i < 10; i++)
				System.out.println("You said: " + line);
		}
		
		if(line == "DESOCUPADO") 
		{
			for(int i = 0; i < 10; i++)
				System.out.println("MENSAJE: " + i);
		}
		
	}

	private static Scanner extracted() {
		return new Scanner(System.in);
	}
}