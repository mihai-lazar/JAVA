import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import javax.swing.JFrame;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Prueba2 {
	
	private JFrame frame;
	DatabaseReference ref;
	DatabaseReference ref2;
	JLabel EstadoDB = new JLabel("");
	private JLabel EstadoTXT;
	
	String ID = null;
	String ESTADO = null;
	String USOS = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba2 window = new Prueba2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Prueba2() throws IOException, InterruptedException, ExecutionException {
		initialize();
	}
	
	private void initialize() throws IOException, InterruptedException, ExecutionException 
	{
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		FileInputStream serviceAccount = new FileInputStream("./USER.json");				    //TOQUEN DE AUTORIZACION

		FirebaseOptions options = new FirebaseOptions.Builder()									//NUEVO OBJETO					
		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))						//LOS CREDENCIALES		
		    .setDatabaseUrl("https://gsmuai-ed9e5.firebaseio.com/")								//URL BASE DE DATOS
		    .build();																			//QUE SE JECUTA

		FirebaseApp.initializeApp(options);														//INICIAMOS LA CONECCION		
		ref = FirebaseDatabase.getInstance()
			    .getReference("MAQUINAS/1/ESTADO");
		
		ref2 = FirebaseDatabase.getInstance()
			    .getReference("MAQUINAS/");
		
		
		Check();

		
		ref2.addValueEventListener(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot dataSnapshot) {		  
		            for(DataSnapshot child : dataSnapshot.getChildren()) {
		            	String ID = child.getKey();
		            	for(DataSnapshot datos : child.getChildren()) {
		            		String dato = datos.getKey();
		            		if(dato.equals("ESTADO")) {
		            			ESTADO = (String) datos.getValue();
		            			System.out.println(ESTADO);
		            		}
		            		
		            		if(dato.equals("USO")) {
		            			for(DataSnapshot usos : datos.getChildren()) {
		            				String uso = usos.getKey();
		            				System.out.println(usos.getValue());
		            				for(DataSnapshot tiempo : usos.getChildren()) {
		            					System.out.println(tiempo.getValue());
		            				}
		            			}
		            		}
		            	}

		            	//System.out.println(key + " " + estado);
		            	//System.out.println(value);
		            	
		            }
				  
				 				  
			    //Object document = dataSnapshot.getValue();
			    //EstadoDB.setText((String) document);  
			    //System.out.println(dataSnapshot.getValue());
			    //System.out.println(dataSnapshot);
			  }

			  @Override
			  public void onCancelled(DatabaseError error) {
			  }
		});
		
		
		
		
		
		EstadoDB.setFont(new Font("Tahoma", Font.PLAIN, 45));
		EstadoDB.setHorizontalAlignment(SwingConstants.CENTER);		
		EstadoDB.setBounds(10, 76, 364, 38);
		frame.getContentPane().add(EstadoDB);
		
		EstadoTXT = new JLabel("ESTADO");
		EstadoTXT.setHorizontalAlignment(SwingConstants.CENTER);
		EstadoTXT.setFont(new Font("Tahoma", Font.PLAIN, 21));
		EstadoTXT.setBounds(10, 27, 364, 18);
		frame.getContentPane().add(EstadoTXT);	
		
	}
	
	public void Check() {
		ref.addValueEventListener(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot dataSnapshot) {
			    Object document = dataSnapshot.getValue();
			    EstadoDB.setText((String) document); 
			    //System.out.println(document);
			  }

			  @Override
			  public void onCancelled(DatabaseError error) {
			  }
		});
	}
	
	
	public class Maquina {

	    public String id;
	    public String estado;
	    public String[] tiempos;
	    public Map<String, Boolean> stars = new HashMap<>();

	    public Maquina() {
	        // Default constructor required for calls to DataSnapshot.getValue(User.class)
	    }

	    public Maquina(String id, String estado, String[] tiempos) {
	        this.id = id;
	        this.estado = estado;
	        this.tiempos = tiempos;
	    }
	    
	    public Map<String, Object> toMap() {
	        HashMap<String, Object> result = new HashMap<>();
	        result.put("key", id);
	        result.put("ESTADO", estado);
	        result.put("USO", tiempos);
	        return result;
	    }

	}
	
	
}

