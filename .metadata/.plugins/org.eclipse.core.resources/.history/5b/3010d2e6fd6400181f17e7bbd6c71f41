package p1ab;

public class Totem {
	
	Jaula jaula;
	String NFC;
	String QR;
	
	public Totem(Jaula jaula, String NFC, String QR) {
		this.jaula = jaula;
		this.NFC = NFC;
		this.QR = QR;
	}
	
	public void getInfo(String metod) {
		if(metod.equals("NFC"))
			System.out.println("METODO NFC");
		if(metod.equals("QR"))
			System.out.println("METODO QR");
		if(metod.equals("QR") || metod.equals("NFC")) {
			jaula.getDatos();
		}
	}
	
	
	//EL TOQUEN DEVUELVE EL CODIGO
	public String getNFC() {
		return NFC;
	}
	
	public String getQR() {
		return QR;
	}

}
