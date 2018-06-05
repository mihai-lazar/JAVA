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


package p3a;

public class MainPila {
	
	public static void main(String[] args) {
		
		Barco Barco = new Barco(6, 10);
		
		Barco.paint();
		
	}
	

}
