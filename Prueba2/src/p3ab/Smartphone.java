package p3ab;


public class Smartphone extends User{
	
	String coordenadas;
	
	public Smartphone(String name) {
		super(name);
	}
	
	public String getCoor() {
		return coordenadas;
	}
	
	public void setCoor(String coord) {
		coordenadas = coord;
	}
	
	public void puntos() {
		System.out.println("LA RUTA A FINALIZADO! FELICITACIONES " + getName() + " TU PUNTAJE TOTAL ES: " + points);
		
		if(points == 1)
			System.out.println("GANASTE UN JUGO!");
		if(points == 2)
			System.out.println("GANASTE UN PELUCHE!");
		if(points == 3)
			System.out.println("GANASTE UNA ENTRADA GRATIS!");
		
	}
	

}
