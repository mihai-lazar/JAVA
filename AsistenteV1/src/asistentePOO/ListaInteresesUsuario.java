package asistentePOO;

public class ListaInteresesUsuario {
	
	private EstadoInteresesUsuario[] intereses = {EstadoInteresesUsuario.NO_INTERESADO, EstadoInteresesUsuario.NO_INTERESADO, EstadoInteresesUsuario.NO_INTERESADO, EstadoInteresesUsuario.NO_INTERESADO, EstadoInteresesUsuario.NO_INTERESADO, EstadoInteresesUsuario.NO_INTERESADO};
	//int [] intereses = {0, 0, 0, 0, 0, 0};
	
	public  void setInteres(int index, EstadoInteresesUsuario estado) {
		intereses[index] = estado;
	}
	
	public  EstadoInteresesUsuario getInteres(int index) {
		return intereses[index];
	}

	public  int getLargo() {
		return intereses.length;
	}
}
