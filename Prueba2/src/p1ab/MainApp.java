package p1ab;

public class MainApp {
	
	public static void main(String[] args) {
		
		//CREAMOS EL ZOLOGICO
		Zoologico ZOO = new Zoologico("WinBoo");
		//CREAMOS LOS ANIMALES
		Especie LOBO = new Especie("1", "JUAL", "LOBO", "OBEJAS Y CIERVOS", "GRANDE", "ALASKA");
		Especie OBEJA = new Especie("2", "ALDS", "OBEJA", "PASTOS", "CHICO", "CHILE");
		Especie CIERVO = new Especie("3", "QVEX", "CIERVO", "PASTOS", "CHICO", "AGRENTINA");
		//CREAMOS LAS JAULAS
		Jaula JAULA1 = new Jaula("1");
		Jaula JAULA2 = new Jaula("2");
		//AGREGAMOS LOS ANIMALES A LAS JAULAS
		JAULA1.addAnimal(LOBO);
		JAULA2.addAnimal(OBEJA);
		JAULA2.addAnimal(CIERVO);
		//AGREGAMOIS LAS JAULAS AL ZOOLOGICO
		ZOO.addJaula(JAULA1);
		ZOO.addJaula(JAULA2);
		//RELACIONAMOS LOS TOTEMS CON LAS JAULAS
		Smartphone telefono1 = new Smartphone("NFC1", "QR1");
		Smartphone telefono2 = new Smartphone("NFC2", "QR2");
		Totem TOTEM1 = new Totem(JAULA1, "NFC1", "QR1");
		Totem TOTEM2 = new Totem(JAULA2, "NFC2", "QR2");
		//AGREGAMOS LOS TOTEMS AL ZOOLOGICO
		ZOO.addTotem(TOTEM1);
		ZOO.addTotem(TOTEM2);
		
		
		//PRUEBA DE ACERCAMIENTO
		//SE ASERCA DOS USUARIOS AL TOTEM1 y TOTEM2 CON EL CELULAR Y ESTE LE RESPONDE TANTO QR COMO NFC
		System.out.println(telefono1.getNFC());
		System.out.println(telefono2.getQR());
		//RECIBE LOS DATOS PARA QR O NFC
		//DESPUES SE MUESTAN LOS DATOS ACORDE A LO PEDIDO
		ZOO.getTotemInfoNFC(telefono1.getNFC());	
		ZOO.getTotemInfoQR(telefono2.getQR());
		
		
		
	}

}
