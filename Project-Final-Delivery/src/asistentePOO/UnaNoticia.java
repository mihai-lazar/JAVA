package asistentePOO;

public class UnaNoticia {
	
	private String titulo;
	private String url;
	private EstadoNoticiaUsuario estadoActual = EstadoNoticiaUsuario.NO_VISTA;
	
	public UnaNoticia(String titulo, String url) {
	    this.titulo = titulo;
	    this.url = url;
	}
	
	public String getTitulo() {
	    return titulo;
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

