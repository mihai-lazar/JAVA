package asistentePOO;

public class ListaLlamadasOcupadoUsuario {
	
	private UnaLlamada[] agendaLlamadas = new UnaLlamada[0];
	
	public ListaLlamadasOcupadoUsuario() {
	}
	
	public  void agregarLlamada(UnaLlamada llamada) {
		UnaLlamada[] nuevasAgendaLlamadas = new UnaLlamada[agendaLlamadas.length + 1];

	    for(int i = 0 ; i < agendaLlamadas.length ; i++) {
	    	nuevasAgendaLlamadas[i] = agendaLlamadas[i];
	        }
	    nuevasAgendaLlamadas[agendaLlamadas.length] = llamada;
	    agendaLlamadas = nuevasAgendaLlamadas;
	}
	
	public  UnaLlamada getLlamada(int index) {
		return agendaLlamadas[index];
	}
	
	public  int getLargo() {
		return agendaLlamadas.length;
	}
	
	public  void vaciarLlamadas() {
		agendaLlamadas = new UnaLlamada[0];
	}
	
		
}
