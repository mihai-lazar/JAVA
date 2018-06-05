package asistentePOO;

import java.util.Date;

public class UnaLlamada {
	private String nombre;
	private String numero;
	private Date fechaHora;
	
	public UnaLlamada(String nombre, String numero, Date fechaHora) {
	    this.nombre = nombre;
	    this.numero = numero;
	    this.fechaHora = fechaHora;
	}
	
	public String getNombre() {
	    return nombre;
	}
	
	public String getNumero() {
	    return numero;
	}
	
	public Date getFechaHora() {
	    return fechaHora;
	}
}

