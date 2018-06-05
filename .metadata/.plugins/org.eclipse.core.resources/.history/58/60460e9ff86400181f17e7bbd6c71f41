package p2ab;

import java.util.ArrayList;

public class Jaula {
	
	String id;
	ArrayList<Especie> especies;
	String coordenadas;
	
	public Jaula(String id, String coordenadas) {
		this.id = id;
		this.coordenadas = coordenadas;
		this.especies = new ArrayList<Especie>();
	}
	
	public void addAnimal(Especie especie) {
		especies.add(especie);
	}
	
	public void getDatos() {
		System.out.println("COORDENADAS: " + coordenadas); 
		for(int i = 0 ; i < especies.size() ; i++) {
			especies.get(i).showDatos();
		}
	}
	
	public int size() {
		return especies.size();
	}
	
	public String getCoord() {
		return coordenadas;
	}

}
