package Control3;

public class Fibonacci_Apellido2 
{
	public static long serieFibo(long numeroIngresado){
		
		 long valorPrevio = 1;
		 long preValorPrevio = 0;
		 long ciclo = 0;
	     long valorActual = 0;
	     
	     while(ciclo < numeroIngresado-1){
	         valorActual = valorPrevio + preValorPrevio;
	         preValorPrevio = valorPrevio;
	         valorPrevio = valorActual ;
	         ciclo++;
	     }
	    
		  return valorActual;
		 }
	
	public static void main(String[] args) //Si se ingresa 60 retorna 1548008755920, si se ingresa 70 retorna 190392490709135 y
	                                       //con 80 retorna 23416728348467685. Es mas rapido con el ciclo while que de manera recursiova
	                                       //pero existe de igual forma un limite de que tan grande puede ser el numero.
	{
		if(Integer.parseInt(args[0]) == 0)
           	System.out.print(0);
		else
			System.out.print(serieFibo(Integer.parseInt(args[0])));
	}
}
