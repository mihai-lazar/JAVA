package asistentePOO;

public class ListaUsuarios {
	
	private UnUsuario[] agendaUsuarios = new UnUsuario[0];
	
	public ListaUsuarios() {
	}
	
	public  void removerUsuario(int index) {
		UnUsuario[] nuevaAgendaUsuarios = new UnUsuario[agendaUsuarios.length - 1];

		int e = 0;
	    for(int i = 0 ; i < agendaUsuarios.length ; i++) {
	        if(i != index) {
	        	nuevaAgendaUsuarios[e] = agendaUsuarios[i];
	        	e++;
	        }
	    }
	    agendaUsuarios = nuevaAgendaUsuarios;
	}
	
	public  void agregarUsuario(UnUsuario usuario) {
		UnUsuario[] nuevaAgendaUsuarios = new UnUsuario[agendaUsuarios.length + 1];

		int e = 0;
	    for(int i = 0 ; i < nuevaAgendaUsuarios.length ; i++) {
	        if(i > agendaUsuarios.length - 1) {
	        	nuevaAgendaUsuarios[i] = usuario;
	        }else {
	        	nuevaAgendaUsuarios[i] = agendaUsuarios[e];
	        	e++;
	        }
	       
	    }
	    agendaUsuarios = nuevaAgendaUsuarios;
	}
	
	public  UnUsuario getUsuario(int index) {
		return agendaUsuarios[index];
	}
	
	public  int getLargo() {
		return agendaUsuarios.length;
	}

	public int indexOf(UnUsuario usuarioActual) {
		int index = 0;
		for(int i = 0 ; i < agendaUsuarios.length ; i++) {
			if(agendaUsuarios[i].equals(usuarioActual))
				index = i;
		}
		return index;
	}
	
		
}
