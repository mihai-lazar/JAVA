/*
 	Se ejecuta el codigo, se crea un barco con 100 espacios para pilas, se crean 6 pilas con 10 contenedores
 	y se muestran las ubicaciones.
 
 	-  -  -  -  -  X  -  -  -  - 
 	-  -  X  -  -  -  -  -  -  - 
 	-  -  -  -  -  -  -  -  -  - 
 	-  -  -  -  -  -  -  -  -  - 
 	-  -  -  -  -  -  -  -  -  - 
 	-  -  -  X  -  -  -  -  -  - 
 	-  -  -  -  -  -  X  -  -  - 
 	-  -  -  -  -  -  -  -  -  X 
 	-  X  -  -  -  -  -  -  -  - 
 	-  -  -  -  -  -  -  -  -  - 
*/


package p3b;

public class MainPila {
	
	public static void main(String[] args) {
		
		int idP = Integer.parseInt(args[0]);	
		int idC = Integer.parseInt(args[1]);
		
		Barco Barco = new Barco(6, 10);
		
		Barco.paint();
		
		
		for (int row = 0; row < 10; ++row) {
			for (int col = 0; col < 10; ++col) {
				if(Barco.pilas[row][col].id == idP)
					for (int cont = 0; cont < 10; ++cont) {
						if(Barco.pilas[row][col].contenedores[cont].id == idC)
							System.out.println(row + "," + col + "," + cont);
					}	
		    }
		}
		
	}
	

}
