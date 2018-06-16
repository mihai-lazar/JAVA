package asistentePOO;

public class UnUsuario {
	
	private String nombre;
	private int tiempoAviso = 20;
	
	private EstadoUsuario estadoActual = EstadoUsuario.DESOCUPADO;
	private EstadoAvisoUsuario avisoEstado = EstadoAvisoUsuario.NO_AVISADO;
	
	private ListaTareasUsuario agendaTareas = new ListaTareasUsuario();
	private ListaInteresesUsuario intereses = new ListaInteresesUsuario();
	private ListaFeedDesocupadoUsuario feedDesocupado = new ListaFeedDesocupadoUsuario();
	private ListaFeedOcupadoUsuario feedOcupado = new ListaFeedOcupadoUsuario();
	private ListaFeedEliminadasUsuario feedEliminado = new ListaFeedEliminadasUsuario();
	private ListaLlamadasDesocupadoUsuario llamadasDesocupado = new ListaLlamadasDesocupadoUsuario();
	private ListaLlamadasOcupadoUsuario llamadasOcupado = new ListaLlamadasOcupadoUsuario();
	
	
	
	//NOMBRE
	public UnUsuario(String nombre) {
	    this.nombre = nombre;
	}
	
	public String getNombre() {
	    return nombre;
	}
	
	
	//TIEMPO AVISO
	public  void setTiempo(int tiempo) {
		tiempoAviso = tiempo;
	}
	
	public  int getTiempo() {
		return tiempoAviso;
	}
	
	
	//ESTADO
	public void setEstado(EstadoUsuario estado) {
		estadoActual = estado;
	}
	
	public EstadoUsuario getEstado() {
		return estadoActual;
	}
	
	
	//AVISO
	public void setAviso(EstadoAvisoUsuario aviso) {
		avisoEstado = aviso;
	}

	public EstadoAvisoUsuario getAviso() {
		return avisoEstado;
	}
	
	
	//LISTA TAREAS
	public ListaTareasUsuario getListaTareas() {
		return agendaTareas;
	}
	
	
	//FEED
	public ListaFeedDesocupadoUsuario getFeedDesocupado() {
		return feedDesocupado;
	}
	
	public ListaFeedOcupadoUsuario getFeedOcupado() {
		return feedOcupado;
	}
	
	public ListaFeedEliminadasUsuario getFeedEliminado() {
		return feedEliminado;
	}
	
	
	//LLAMADAS
	public ListaLlamadasDesocupadoUsuario getLlamadasDesocupado() {
		return llamadasDesocupado;
	}
	
	public ListaLlamadasOcupadoUsuario getLlamadasOcupado() {
		return llamadasOcupado;
	}
	
	
	//Intereses
	public ListaInteresesUsuario getIntereses() {
		return intereses;
	}
	
}
