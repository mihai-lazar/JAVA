package asistentePOO;

public class UnaNoticia {
	
	private String nombre;
	private String url;
	private EstadoNoticiaUsuario estadoActual = EstadoNoticiaUsuario.NO_VISTA;
	
	public UnaNoticia(String nombre, String url) {
	    this.nombre = nombre;
	    this.url = url;
	}
	
	public String getNombre() {
	    return nombre;
	}
	
	public void setVista() {
		estadoActual = EstadoNoticiaUsuario.VISTA;
	}
	
	public EstadoNoticiaUsuario getEstado() {
		return estadoActual;
	}
	
	public String getUrl() {
		return url;
	}
	
}

