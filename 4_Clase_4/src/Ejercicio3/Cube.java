package Ejercicio3;

public class Cube 
{
	public static int cube(int i)
	{
		int j = i*i*i;
		return j;
	}
	
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		for (int i = 1; i <= N; i++)
			System.out.println(i + " " + cube(i));
	}
	

}
