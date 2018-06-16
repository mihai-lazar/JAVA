package asistentePOO;

public class ListaFeedEliminadasUsuario {
	
	private UnaNoticia[] noticias = new UnaNoticia[0];
	
	public ListaFeedEliminadasUsuario() {
	}
	
	public  void agregarEliminada(UnaNoticia noticia) {
		UnaNoticia[] nuevasNoticias = new UnaNoticia[noticias.length + 1];

	    for(int i = 0 ; i < noticias.length ; i++) {
	        	nuevasNoticias[i] = noticias[i];
	        }
	    nuevasNoticias[noticias.length] = noticia;
	    noticias = nuevasNoticias;
	}
	
	public  boolean estaEliminada(String titulo) {
		for(int i = 0 ; i < noticias.length ; i++ ) {
			if(noticias[i].getTitulo().equals(titulo))
				return true;	
		}
		return false;
	}
	

}
