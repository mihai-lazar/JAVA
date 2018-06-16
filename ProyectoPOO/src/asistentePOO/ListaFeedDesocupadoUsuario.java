package asistentePOO;

public class ListaFeedDesocupadoUsuario {
	
	private UnaNoticia[] noticias = new UnaNoticia[0];
	
	public ListaFeedDesocupadoUsuario() {
	}
	
	public  void setFeed(ListaFeedDesocupadoUsuario nuevoFeed) {
	    noticias = nuevoFeed.getNoticias();
	}
	
	public  void agregarNoticia(UnaNoticia noticia) {
		UnaNoticia[] nuevasNoticias = new UnaNoticia[noticias.length + 1];

	    for(int i = 0 ; i < noticias.length ; i++) {
	        	nuevasNoticias[i] = noticias[i];
	        }
	    nuevasNoticias[noticias.length] = noticia;
	    noticias = nuevasNoticias;
	}
	
	public  void removerNoticia(int index) {
		UnaNoticia[] nuevasNoticias = new UnaNoticia[noticias.length - 1];

		int e = 0;
	    for(int i = 0 ; i < noticias.length ; i++) {
	        if(i != index) {
	        	nuevasNoticias[e] = noticias[i];
	        	e++;
	        }
	    }
	    noticias = nuevasNoticias;
	}
	
	public  UnaNoticia[] getNoticias() {
		return noticias;
	}
	
	public  UnaNoticia getNoticia(int index) {
		return noticias[index];
	}
	
	public  int getLargo() {
		return noticias.length;
	}
	
	public  boolean estaNoticia(String titulo) {
		for(int i = 0 ; i < noticias.length ; i++ ) {
			if(noticias[i].getTitulo().equals(titulo))
				return true;	
		}
		return false;
	}
	
		
}
