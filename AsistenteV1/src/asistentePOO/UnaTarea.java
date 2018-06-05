package asistentePOO;

import java.util.Date;

public class UnaTarea {
	private String nombre;
	private Date fechaHora;
	
	public UnaTarea(String nombre, Date fechaHora) {
	    this.nombre = nombre;
	    this.fechaHora = fechaHora;
	}
	
	public String getNombre() {
	    return nombre;
	}
	
	public Date getFechaHora() {
	    return fechaHora;
	}
}

