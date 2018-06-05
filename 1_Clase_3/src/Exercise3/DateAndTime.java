package Exercise3;

public class DateAndTime 
{
	public static void main(String[] args) 
	{
		String[] Meses = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviempre","Diciembre"};
		int[] Dias = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int EleccionFormato = Integer.parseInt(args[0]);          
		String NombreDia = args[1];
		int Dia = Integer.parseInt(args[2]);
		int Mes = Integer.parseInt(args[3]);
		int Año = Integer.parseInt(args[4]);
		if(EleccionFormato == 1) 
		{
			System.out.println("American format:");
			System.out.println(NombreDia + ", " + Meses[Mes-1] + " " + Dia + ", " + "20" + Año);
		}else if(EleccionFormato == 2) 
		{
			System.out.println("European format:"); 
			System.out.println(NombreDia + " " + Dia + " " + Meses[Mes-1] + " 20" + Año);
		}
		for(int i = Dia+1; i <= Dias[Mes-1]; i++)
			System.out.println(i); 
	}

}
