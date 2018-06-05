import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class Prueba {
	
	private static final String ESTADO = "ESTADO";											    //CREAMOS LA VARIABLE ESTADO
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException
	{
		FileInputStream serviceAccount = new FileInputStream("./USER.json");				    //TOQUEN DE AUTORIZACION

		FirebaseOptions options = new FirebaseOptions.Builder()									//NUEVO OBJETO					
		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))						//LOS CREDENCIALES		
		    .setDatabaseUrl("https://gsmuai-ed9e5.firebaseio.com/")								//URL BASE DE DATOS
		    .build();																			//QUE SE JECUTA

		FirebaseApp.initializeApp(options);														//INICIAMOS LA CONECCION
		Firestore db = FirestoreClient.getFirestore();											//OBTENEMOS LA BASE DE DATOS
		
		
		Map < String, Object > NuevoEstado = new HashMap < > ();							    //CREAMOS EL MAPA DE LOS DATOS
		NuevoEstado.put(ESTADO, "ONLINE");														//LE ASIGNAMOS EL VALOR A ESTADO
		ApiFuture<WriteResult> future = db.collection("ID").document("UNO").set(NuevoEstado);	//EJECUTAMOS EL QUERRY
		System.out.println("Funciono a " + future.get().getUpdateTime());						//IMPRIMIMOS EL TIEMPO DE UPDATE
		
		
		ApiFuture<DocumentSnapshot> ValorS = db.collection("ID").document("UNO").get();   		//EJECUTAMOS QUERRY
		DocumentSnapshot Valor = ValorS.get();											   		//OBTENEMOS EL QUERRY
	    System.out.println(Valor.getString("ESTADO"));											//IMPRIMIMOS EL ESTADO
	    
		
		
		
	}

}
