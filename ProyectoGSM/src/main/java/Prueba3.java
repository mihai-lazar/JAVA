import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class Prueba3 {
	
	private JFrame frame;
	
	String ID = null;
	String ESTADO = null;
	String USOS = null;
	
	String selectedID = "";
	
	DataSnapshot todo;
	
	long horasTotales;
	
	int test = 0;
	
	private static JList<String> listaTiempos = new JList<String>();
	private static DefaultListModel<String> listaTiemposDefault = new DefaultListModel<String>();
	
	private static JList<String> listaMaquinas = new JList<String>();
	private static DefaultListModel<String> listaMaquinasDefault = new DefaultListModel<String>();

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba3 window = new Prueba3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Prueba3() throws IOException, InterruptedException, ExecutionException {
		initialize();
	}
	
	private void initialize() throws IOException, InterruptedException, ExecutionException 
	{	
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 696, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Image img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		ImageIcon img = new ImageIcon("./icono.png");
		frame.setIconImage(img.getImage());
		
		JLabel estadoMaquina = new JLabel("...");
		estadoMaquina.setForeground(Color.GRAY);
		estadoMaquina.setFont(new Font("Tahoma", Font.BOLD, 35));
		estadoMaquina.setHorizontalAlignment(SwingConstants.RIGHT);		
		estadoMaquina.setBounds(197, 135, 218, 38);
		frame.getContentPane().add(estadoMaquina);
		
		JLabel idMaquina = new JLabel("...");
		idMaquina.setForeground(Color.GRAY);
		idMaquina.setHorizontalAlignment(SwingConstants.RIGHT);
		idMaquina.setFont(new Font("Tahoma", Font.BOLD, 35));
		idMaquina.setBounds(197, 86, 218, 38);
		frame.getContentPane().add(idMaquina);
		
		JLabel tiempoMaquina = new JLabel("...");
		tiempoMaquina.setHorizontalAlignment(SwingConstants.RIGHT);
		tiempoMaquina.setForeground(Color.GRAY);
		tiempoMaquina.setFont(new Font("Tahoma", Font.BOLD, 35));
		tiempoMaquina.setBounds(197, 184, 218, 38);
		frame.getContentPane().add(tiempoMaquina);
		
		
		
		FileInputStream serviceAccount = new FileInputStream("./USER.json");				    //TOQUEN DE AUTORIZACION
		
		FirebaseOptions options = new FirebaseOptions.Builder()									//NUEVO OBJETO					
		    .setCredentials(GoogleCredentials.fromStream(serviceAccount))						//LOS CREDENCIALES		
		    .setDatabaseUrl("https://gsmuai-ed9e5.firebaseio.com/")								//URL BASE DE DATOS
		    .build();																			//QUE SE JECUTA

		FirebaseApp.initializeApp(options);														//INICIAMOS LA CONECCION		
		
		DatabaseReference ref = FirebaseDatabase.getInstance()
			    .getReference("MAQUINAS/");	
		
    	SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		ref.addValueEventListener(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot dataSnapshot) {		
				  	
				  	todo = dataSnapshot;
				    
				    listaMaquinasDefault = new DefaultListModel<String>();
				    
		            for(DataSnapshot child : dataSnapshot.getChildren()) {
		            	String ID = child.getKey();
		            	listaMaquinasDefault.addElement(ID);	  
		            	if(ID.equals(selectedID)) {
		            		horasTotales = 0;
		            		listaTiemposDefault = new DefaultListModel<String>();
							idMaquina.setText(ID);
							for(DataSnapshot datos : child.getChildren()) {
								String dato = datos.getKey();
								if(dato.equals("ESTADO")) {
									ESTADO = (String) datos.getValue();
									estadoMaquina.setText(ESTADO); 
								}
					            		
								if(dato.equals("USO")) {
									for(DataSnapshot usos : datos.getChildren()) {
										for(DataSnapshot tiempo : usos.getChildren()) {
											String tiemp = String.valueOf(tiempo.getValue());
											String[] splited = tiemp.split(" ");
											if(splited.length != 2) {
												splited = new String[2];
												splited[0] = tiemp;
												splited[1] =  "0";
											}
					            						
											long milliSeconds1= Long.parseLong(splited[0]);
											long milliSeconds2= Long.parseLong(splited[1]);
											String datosString = fecha.format (milliSeconds1);
					            						
											if(splited[1].equals("0")) {
					            							
												listaTiemposDefault.addElement(datosString);
					            							
											}else{	            						 						
					            						
												long millis = milliSeconds2 - milliSeconds1;
												
												horasTotales = horasTotales + millis;
												
												int h = (int) ((millis / 1000) / 3600);
												int m = (int) (((millis / 1000) / 60) % 60);
												int s = (int) ((millis / 1000) % 60);
					            						
												listaTiemposDefault.addElement(datosString + " " + h + ":" + m + ":" + s); 
											}
										}
									}
								}
							}
							
							int h = (int) ((horasTotales / 1000) / 3600);
							int m = (int) (((horasTotales / 1000) / 60) % 60);
							int s = (int) ((horasTotales / 1000) % 60);				
							String tiempoTotal = Integer.toString(h) + ":" + Integer.toString(m) + ":" + Integer.toString(s);
				            tiempoMaquina.setText(tiempoTotal); 
				        
				            listaTiempos.setModel(listaTiemposDefault); 
				            		
						}
		            	
		            }
		            
		            listaMaquinas.setModel(listaMaquinasDefault); 
		            
			  }

			  @Override
			  public void onCancelled(DatabaseError error) {
			  }
		});
		
		
		JLabel EstadoTXT = new JLabel("REGISTROS");
		EstadoTXT.setForeground(Color.GRAY);
		EstadoTXT.setHorizontalAlignment(SwingConstants.LEFT);
		EstadoTXT.setFont(new Font("Tahoma", Font.BOLD, 21));
		EstadoTXT.setBounds(425, 11, 218, 18);
		frame.getContentPane().add(EstadoTXT);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 40, 245, 277);
		frame.getContentPane().add(scrollPane);		
		scrollPane.setViewportView(listaTiempos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 177, 225);
		frame.getContentPane().add(scrollPane_1);	
		scrollPane_1.setViewportView(listaMaquinas);
		
		JButton aceptarMaquina = new JButton("ACEPTAR");
		aceptarMaquina.setFont(new Font("Tahoma", Font.BOLD, 14));
		aceptarMaquina.setForeground(Color.BLACK);
		aceptarMaquina.setBackground(Color.BLACK);
		aceptarMaquina.setBounds(10, 276, 177, 41);
		frame.getContentPane().add(aceptarMaquina);
		
		JLabel lblMaquinas = new JLabel("MAQUINAS");
		lblMaquinas.setForeground(Color.GRAY);
		lblMaquinas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaquinas.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMaquinas.setBounds(10, 11, 218, 18);
		frame.getContentPane().add(lblMaquinas);
		
		aceptarMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionIndex = listaMaquinas.getSelectedIndex();    // revisamos el index para que existe una seleccion
				if (seleccionIndex >= 0) {
					
					selectedID = listaMaquinas.getSelectedValue();
							  
					listaTiemposDefault = new DefaultListModel<String>();
							    
					for(DataSnapshot child : todo.getChildren()) {
						String ID = child.getKey();
						if(ID.equals(selectedID)) {
							horasTotales = 0;
							idMaquina.setText(ID);
							for(DataSnapshot datos : child.getChildren()) {
								String dato = datos.getKey();
								if(dato.equals("ESTADO")) {
									ESTADO = (String) datos.getValue();
									estadoMaquina.setText(ESTADO); 
								}
					            		
								if(dato.equals("USO")) {
									for(DataSnapshot usos : datos.getChildren()) {
										for(DataSnapshot tiempo : usos.getChildren()) {
											String tiemp = String.valueOf(tiempo.getValue());
											String[] splited = tiemp.split(" ");
											if(splited.length != 2) {
												splited = new String[2];
												splited[0] = tiemp;
												splited[1] =  "0";
											}
					            						
											long milliSeconds1= Long.parseLong(splited[0]);
											long milliSeconds2= Long.parseLong(splited[1]);
											String dateAsString1 = fecha.format (milliSeconds1);
					            						
											if(splited[1].equals("0")) {
					            							
												listaTiemposDefault.addElement(dateAsString1);
					            							
											}else {	            						 						
					            						
												long millis = milliSeconds2 - milliSeconds1;
												
												horasTotales = horasTotales + millis;
												
												int h = (int) ((millis / 1000) / 3600);
												int m = (int) (((millis / 1000) / 60) % 60);
												int s = (int) ((millis / 1000) % 60);
					            						
												listaTiemposDefault.addElement(dateAsString1 + " " + h + ":" + m + ":" + s); 
											}
										}
									}
								}
							}
						}
					            	
					}
					
					int h = (int) ((horasTotales / 1000) / 3600);
					int m = (int) (((horasTotales / 1000) / 60) % 60);
					int s = (int) ((horasTotales / 1000) % 60);
					String tiempoTotal = Integer.toString(h) + ":" + Integer.toString(m) + ":" + Integer.toString(s);
		            tiempoMaquina.setText(tiempoTotal);         
				
					listaTiempos.setModel(listaTiemposDefault);   
							 				  
				}
			}
		});
	}
}


					
				
		
	


