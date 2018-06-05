package asistentePOO;

public class ListaTareasUsuario {
	
	private UnaTarea[] agendaTareas = new UnaTarea[0];
	
	public ListaTareasUsuario() {
	}
	
	public  void removerTarea(int index) {
		UnaTarea[] nuevaAgendaTareas = new UnaTarea[agendaTareas.length - 1];

		int e = 0;
	    for(int i = 0 ; i < agendaTareas.length ; i++) {
	        if(i != index) {
	        	nuevaAgendaTareas[e] = agendaTareas[i];
	        	e++;
	        }
	    }
	    agendaTareas = nuevaAgendaTareas;
	}
	
	public  void agregarTarea(int index, UnaTarea evento) {
		UnaTarea[] nuevaAgendaTareas = new UnaTarea[agendaTareas.length + 1];

		int e = 0;
	    for(int i = 0 ; i < nuevaAgendaTareas.length ; i++) {
	        if(i == index) {
	        	nuevaAgendaTareas[i] = evento;
	        }else {
	        	nuevaAgendaTareas[i] = agendaTareas[e];
	        	e++;
	        }
	       
	    }
	    agendaTareas = nuevaAgendaTareas;
	}
	
	public  UnaTarea getTarea(int index) {
		return agendaTareas[index];
	}
	
	public  int getLargo() {
		return agendaTareas.length;
	}
	
		
}
