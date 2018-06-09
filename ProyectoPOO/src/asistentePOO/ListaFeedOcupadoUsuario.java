package asistentePOO;

public class ListaFeedOcupadoUsuario {
	
	private UnaNoticia[] noticias = new UnaNoticia[0];
	
	public ListaFeedOcupadoUsuario() {
	}
	
	public  void agregarNoticia(UnaNoticia noticia) {
		UnaNoticia[] nuevasNoticias = new UnaNoticia[noticias.length + 1];

	    for(int i = 0 ; i < noticias.length ; i++) {
	        	nuevasNoticias[i] = noticias[i];
	        }
	    nuevasNoticias[noticias.length] = noticia;
	    noticias = nuevasNoticias;
	}
	
	public  UnaNoticia getNoticia(int index) {
		return noticias[index];
	}
	
	public  int getLargo() {
		return noticias.length;
	}
	
	public  void vaciarFeed() {
		noticias = new UnaNoticia[0];
	}
		
}
