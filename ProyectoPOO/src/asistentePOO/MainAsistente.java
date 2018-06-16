package asistentePOO;

import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import com.toedter.calendar.JCalendar;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

public class MainAsistente {

	private JFrame frame;
	private JTextField nombreUsuarioNuevo;
	private static JLabel nombreUsuarioActivo = new JLabel("");

	private static ListaUsuarios usuariosLista = new ListaUsuarios();
	private static UnUsuario usuarioActual;
	private UnUsuario usuarioBorrar;

	private static JList<String> usuariosNombresLista = new JList<String>();
	private static DefaultListModel<String> usuariosNombresListaDefault = new DefaultListModel<String>();

	private static JList<String> agendaTareasLista = new JList<String>();
	private static DefaultListModel<String> agendaTareasListaDefault = new DefaultListModel<String>();

	private static JList<String> feedLista = new JList<String>();
	private static DefaultListModel<String> feedListaDefault = new DefaultListModel<String>();
	
	private static JList<String> llamadasLista = new JList<String>();
	private static DefaultListModel<String> llamadasListaDefault = new DefaultListModel<String>();

	private JRadioButton estadoUsuario = new JRadioButton("OCUPADO");
	
	private static JCheckBox feedDeporte = new JCheckBox("DEPORTE");
	private static JCheckBox feedTecnologia = new JCheckBox("TECNOLOGIA");
	private static JCheckBox feedNacional = new JCheckBox("NACIONAL");
	private static JCheckBox feedInternacional = new JCheckBox("INTERNACIONAL");
	private static JCheckBox feedComida = new JCheckBox("COMIDA");
	private static JCheckBox feedModa = new JCheckBox("MODA");                       //Seleccion interes Moda
	private static JCheckBox[] intereses = new JCheckBox[]{feedDeporte, feedTecnologia, feedNacional, feedInternacional, feedComida, feedModa};
	
	private JTextField nombreTareaNueva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAsistente window = new MainAsistente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainAsistente() {
		initialize();
	}
	
	public static ListaUsuarios getAgendaUsuarios() {
		return usuariosLista;
	}
	public static UnUsuario getUsuarioActual() {
		return usuarioActual;
	}
	public static DefaultListModel<String> getLlamadasListaDefault(){
		return llamadasListaDefault;
	}
	public static JList<String> getLlamadasLista(){
		return llamadasLista;
	}
	public static DefaultListModel<String> getFeedListaDefault(){
		return feedListaDefault;
	}
	public static JList<String> getFeedLista(){
		return feedLista;
	}	
	public static DefaultListModel<String> getAgendaTareasListaDefault(){
		return agendaTareasListaDefault;
	}
	public static JList<String> getAgendaTareasLista(){
		return agendaTareasLista;
	}
	public static DefaultListModel<String> getUsuariosNombresListaDefault(){
		return usuariosNombresListaDefault;
	}	
	public static JList<String> getUsuariosNombresLista(){
		return usuariosNombresLista;
	}
	
	public static JLabel getNombreUsuarioActivo(){
		return nombreUsuarioActivo;
	}
	public static JCheckBox getInteres(int index){
		return intereses[index];
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Timer FeedTimer = new Timer();                                                   //Creacion del timer para el feed
		FeedTimer.schedule(new TimerFeedLlamadas(), 0, 5000); 							 //Creacion de los parametros del timer
		
		Timer EventosTimer = new Timer();                                                //Creacion del timer para el feed
		EventosTimer.schedule(new TimerTareas(), 0, 1000); 							     //Creacion de los parametros del timer
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 564, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("./icon.png");
		frame.setIconImage(img.getImage());
		
		JTabbedPane PanelTabs = new JTabbedPane(JTabbedPane.TOP);
		PanelTabs.setForeground(Color.BLACK);
		PanelTabs.setBackground(Color.WHITE);
		PanelTabs.setBounds(10, 45, 538, 362);
		frame.getContentPane().add(PanelTabs);
		
		JPanel UsuariosTab = new JPanel();
		UsuariosTab.setBackground(Color.WHITE);
		UsuariosTab.setForeground(Color.BLACK);
		PanelTabs.addTab("USUARIOS", null, UsuariosTab, null);
		UsuariosTab.setLayout(null);
		
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(139, 11, 188, 203);
				UsuariosTab.add(scrollPane_1);
				scrollPane_1.setViewportView(usuariosNombresLista);
				
				
				//Botones
				//Boton de agregar usuario
				JButton agregarUsuarioNuevo = new JButton("AGREGAR");                        //al precionar el boton de agregar usuario
				agregarUsuarioNuevo.setBackground(Color.BLACK);
				agregarUsuarioNuevo.setBounds(139, 292, 188, 23);
				UsuariosTab.add(agregarUsuarioNuevo);
				

				//Text field	
				nombreUsuarioNuevo = new JTextField();
				nombreUsuarioNuevo.setBounds(139, 259, 188, 20);
				UsuariosTab.add(nombreUsuarioNuevo);
				nombreUsuarioNuevo.setColumns(10);
				
				//Boton de eliminar usuario
				JButton eliminarUsuario = new JButton("ELIMINAR");                       //al precionar el boton de eliminar usuario
				eliminarUsuario.setBackground(Color.BLACK);
				eliminarUsuario.setForeground(Color.BLACK);
				eliminarUsuario.setBounds(238, 225, 89, 23);
				UsuariosTab.add(eliminarUsuario);
				
				//Boton de elejir usuario		
				JButton aceptarUsuario = new JButton("ACEPTAR");
				aceptarUsuario.setBackground(Color.BLACK);
				aceptarUsuario.setBounds(139, 225, 89, 23);
				UsuariosTab.add(aceptarUsuario);
				aceptarUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int seleccionIndex = usuariosNombresLista.getSelectedIndex();     // obtenemos el index de la seleccion
						if (seleccionIndex >= 0) {
							estadoUsuario.setEnabled(true);

							usuarioActual = usuariosLista.getUsuario(seleccionIndex);        // seleccionamos y extraemos al usuario elejido
							nombreUsuarioActivo.setText(usuarioActual.getNombre());                  // seteamos el nombre del usuario activo

							agendaTareasListaDefault = new DefaultListModel<String>();   // reiniciamos la lista de eventos
							agendaTareasLista.setModel(agendaTareasListaDefault);       // ponemos el modelo (copiamos de la defout a la que se muestra)
							
							feedListaDefault = new DefaultListModel<String>();            // reiniciamos la lista de eventos
							feedLista.setModel(feedListaDefault);                         // ponemos el modelo (copiamos de la defout a la que se muestra)
							
							
							llamadasListaDefault = new DefaultListModel<String>();            // reiniciamos la lista de eventos
							llamadasLista.setModel(llamadasListaDefault);                         // ponemos el modelo (copiamos de la defout a la que se muestra)
							

							for (int i = 0; i < usuarioActual.getListaTareas().getLargo(); i++) {             // revisamos todos los eventos que tiene el usuario en su lista personal
								UnaTarea evento = usuarioActual.getListaTareas().getTarea(i);           // extraemos el evento de la lista personal
								
								String fechaString  = new SimpleDateFormat("dd/MM/yyyy").format(evento.getFechaHora());	
								String horaString  = new SimpleDateFormat("HH:mm").format(evento.getFechaHora());	
								agendaTareasListaDefault.addElement("<html>" + evento.getNombre() + "<br>" + fechaString + " " + horaString + "</span></html>");
							}
							
							for (int i = 0; i < usuarioActual.getFeedDesocupado().getLargo(); i++) {               // revisamos todos los feed que tiene el usuario en su lista feed
								feedListaDefault.addElement(usuarioActual.getFeedDesocupado().getNoticia(i).getTitulo());         // agregamos cada feed de la lista personal a la lista defoult
							}
							
							for (int i = 0; i < usuarioActual.getLlamadasDesocupado().getLargo(); i++) {                   // revisamos todos los feed que tiene el usuario en su lista feed						
								String horaFechaString  = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(usuarioActual.getLlamadasDesocupado().getLlamada(i).getFechaHora());  
								llamadasListaDefault.addElement("<html>" + usuarioActual.getLlamadasDesocupado().getLlamada(i).getNombre() + "<br>" +  usuarioActual.getLlamadasDesocupado().getLlamada(i).getNumero() + "<br>" + horaFechaString + "</html>");             
							}
							
							if(usuarioActual.getEstado() == EstadoUsuario.OCUPADO)
								estadoUsuario.setSelected(true);
							else
								estadoUsuario.setSelected(false);
							
							for (int i = 0; i < usuarioActual.getIntereses().getLargo(); i++) {           // revisamos todos los intereses del usuario
								intereses[i].setEnabled(true);
								if(usuarioActual.getIntereses().getInteres(i) == EstadoInteresesUsuario.NO_INTERESADO)                          // si es que no tiene el interes i se deselecciona
									intereses[i].setSelected(false);
								else
									intereses[i].setSelected(true); // si es que se tiene el interes i se selecciona
							}
						}
					}
				});
				eliminarUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int seleccionIndex = usuariosNombresLista.getSelectedIndex();    // revisamos el index para que existe una seleccion
						if (seleccionIndex >= 0) {
							usuarioBorrar = usuariosLista.getUsuario(seleccionIndex);
							if(usuarioBorrar.equals(usuarioActual)) {
								estadoUsuario.setEnabled(false);
								estadoUsuario.setSelected(false);
							
								for (int i = 0; i < usuarioActual.getIntereses().getLargo(); i++) {           // revisamos todos los intereses del usuario
									intereses[i].setSelected(false);
									intereses[i].setEnabled(false);
								}
								
								nombreUsuarioActivo.setText("");                             // eliminnamos el nombre del usuario

								agendaTareasListaDefault = new DefaultListModel<String>();  // reniciamos la lista de eventos default
								agendaTareasLista.setModel(agendaTareasListaDefault);      // ponemos el modelo
								feedListaDefault = new DefaultListModel<String>();           // reniciamos la lista de feed default
								feedLista.setModel(feedListaDefault);                        // ponemos el modelo
								llamadasListaDefault = new DefaultListModel<String>();           // reniciamos la lista de feed default
								llamadasLista.setModel(llamadasListaDefault);                        // ponemos el modelo
								
							}
							
							usuariosNombresListaDefault.removeElementAt(seleccionIndex); // removimos el nombre de la lista defoult
							usuariosNombresLista.setModel(usuariosNombresListaDefault);   
							usuariosLista.removerUsuario(seleccionIndex);                        // removimos el usuario de la lista de usuarios
						}
					}
				});
				agregarUsuarioNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (nombreUsuarioNuevo.getText().trim().length() > 0) {              //revisamos que no sean solo espacios en blanco
							UnUsuario nuevoUsuario = new UnUsuario(nombreUsuarioNuevo.getText());                            // creo un nuevo usuario
							usuariosLista.agregarUsuario(nuevoUsuario);                                 // agrego el nuevo usuario a la lista de usuarios
							
							usuariosNombresListaDefault.addElement(nuevoUsuario.getNombre());     // agregar el nombre del nuevo usuario a la lista defoult
							usuariosNombresLista.setModel(usuariosNombresListaDefault);      // seteamos el modeo de la lista visible a la lista defailt

							nombreUsuarioNuevo.setText("");                                  // eliminamos el texto del recuadro

						}
					}
				});
		
		JPanel AgendaTab = new JPanel();
		AgendaTab.setBackground(Color.WHITE);
		PanelTabs.addTab("AGENDA", null, AgendaTab, null);
		AgendaTab.setLayout(null);
		
			
        //Paneles de scroll
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(139, 11, 188, 203);
			AgendaTab.add(scrollPane);
			scrollPane.setViewportView(agendaTareasLista);
			
			nombreTareaNueva = new JTextField();
			nombreTareaNueva.setForeground(Color.BLACK);
			nombreTareaNueva.setBackground(Color.WHITE);
			nombreTareaNueva.setBounds(139, 225, 188, 20);
			AgendaTab.add(nombreTareaNueva);
			nombreTareaNueva.setColumns(10);
			
			//Boton de agregar evento de agenda
			JButton agregarEventoAgenda = new JButton("AGREGAR");
			agregarEventoAgenda.setBackground(Color.BLACK);
			agregarEventoAgenda.setBounds(200, 259, 127, 23);
			AgendaTab.add(agregarEventoAgenda);
			
			
			//Spiner para la hora
			JSpinner eleccionHora = new JSpinner(new SpinnerDateModel(new Date(1523242800653L), null, null, Calendar.HOUR_OF_DAY));
			eleccionHora.setBounds(139, 259, 51, 20);
			AgendaTab.add(eleccionHora);
			JSpinner.DateEditor de = new JSpinner.DateEditor(eleccionHora, "HH:mm");
			eleccionHora.setEditor(de);
			
			//Boton de eliminar evento de agenda
			JButton eliminarTareaAgenda = new JButton("ELIMINAR");
			eliminarTareaAgenda.setBackground(Color.BLACK);
			eliminarTareaAgenda.setBounds(139, 292, 188, 23);
			AgendaTab.add(eliminarTareaAgenda);
			eliminarTareaAgenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int seleccionIndex = agendaTareasLista.getSelectedIndex();      // se revisa si se tiene algun elemento de
																				     // la agenda selecionado
					if (seleccionIndex >= 0) {
						if(seleccionIndex == 0) {
							if(usuarioActual.getAviso() == EstadoAvisoUsuario.AVISADO) {	
								usuarioActual.setAviso(EstadoAvisoUsuario.NO_AVISADO);
								usuariosNombresListaDefault.set(usuariosLista.indexOf(usuarioActual), usuarioActual.getNombre());
								usuariosNombresLista.setModel(usuariosNombresListaDefault);          // seteamos el modeo de la lista visible a la lista defailt
							}
						}
						
						usuarioActual.getListaTareas().removerTarea(seleccionIndex);                 // lo agregamos a la lista de eventos del usuario
						agendaTareasListaDefault.removeElementAt(seleccionIndex);   // se elimina el elemento de la lista
						agendaTareasLista.setModel(agendaTareasListaDefault);      //ponemos el modelo

					}
				}
			});
			agregarEventoAgenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (nombreUsuarioActivo.getText() != "") {
						if (nombreTareaNueva.getText().trim().length() > 0) {            //revisamos que no sean solo espacios en blanco
							
							JCalendar fechaSeleccion = new JCalendar();
							String titulo = null;
							Object[] parametros = {titulo, fechaSeleccion};					
							Object[] opciones = {"AGENDAR", "CANCELAR"}; 
						
							int siOno = JOptionPane.showOptionDialog(frame, parametros, "FECHA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
						
							if (siOno == JOptionPane.YES_OPTION) {
								String eventoNombre = nombreTareaNueva.getText(); 
								nombreTareaNueva.setText("");                                  // eliminamos el texto del recuadro																				
								
								String fechaString = new SimpleDateFormat("dd/MM/yyyy").format(((JCalendar)parametros[1]).getDate());
							    String horaString  = new SimpleDateFormat("HH:mm").format(eleccionHora.getValue());    						    
								String[] fechaArray = fechaString.split("/");
								String[] horaArray = horaString.split(":");
								
								Calendar fechaHoraEvento = Calendar.getInstance();
								fechaHoraEvento.set(Integer.parseInt(fechaArray[2]), Integer.parseInt(fechaArray[1]) - 1, Integer.parseInt(fechaArray[0]), Integer.parseInt(horaArray[0]), Integer.parseInt(horaArray[1]), 0);
								Date fechaHoraEventoDate = fechaHoraEvento.getTime();      
								
								if(fechaHoraEventoDate.after(new Date())) {
						        						
									UnaTarea nuevoEvento = new UnaTarea(eventoNombre, fechaHoraEventoDate);                                              // creo un nuevo evento
								
									int ubicacion = 0;
									for(int i = 0; i < usuarioActual.getListaTareas().getLargo(); i ++) {
										UnaTarea comparacion = usuarioActual.getListaTareas().getTarea(i);
										if(nuevoEvento.getFechaHora().after(comparacion.getFechaHora())) {
											ubicacion ++;
										}else
											break;
									}
								
									usuarioActual.getListaTareas().agregarTarea(ubicacion, nuevoEvento);							
									agendaTareasListaDefault.add(ubicacion, "<html>" + nuevoEvento.getNombre() + "<br>" + fechaString + " " + horaString + "</html>");
									agendaTareasLista.setModel(agendaTareasListaDefault);                         //ponemos el modelo
								}
							}		
						}
					}
				}
			});
		
		JPanel FeedTab = new JPanel();
		FeedTab.setBackground(Color.WHITE);
		PanelTabs.addTab("FEED", null, FeedTab, null);
		FeedTab.setLayout(null);
		
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(10, 11, 513, 237);
				FeedTab.add(scrollPane_2);
				scrollPane_2.setViewportView(feedLista);
				
				JButton leerFeed = new JButton("LEER");
				leerFeed.setBackground(Color.BLACK);
				leerFeed.setBounds(10, 259, 89, 23);
				FeedTab.add(leerFeed);
				
				JButton borrarFeed = new JButton("BORRAR");
				borrarFeed.setBackground(Color.BLACK);
				borrarFeed.setBounds(109, 259, 89, 23);
				FeedTab.add(borrarFeed);
				
				JButton eliminarVistas = new JButton("ELIMINAR VISTAS");
				eliminarVistas.setBackground(Color.BLACK);
				eliminarVistas.setBounds(10, 293, 188, 23);
				FeedTab.add(eliminarVistas);
				feedDeporte.setEnabled(false);
				feedDeporte.setBackground(Color.WHITE);
				feedDeporte.setBounds(204, 252, 127, 23);
				FeedTab.add(feedDeporte);
				feedTecnologia.setBackground(Color.WHITE);
				feedTecnologia.setBounds(204, 278, 127, 23);
				FeedTab.add(feedTecnologia);
				feedTecnologia.setEnabled(false);
				feedNacional.setBackground(Color.WHITE);
				feedNacional.setBounds(204, 304, 127, 23);
				FeedTab.add(feedNacional);
				feedNacional.setEnabled(false);
				feedInternacional.setBackground(Color.WHITE);
				feedInternacional.setBounds(333, 252, 127, 23);
				FeedTab.add(feedInternacional);
				feedInternacional.setEnabled(false);
				feedComida.setBackground(Color.WHITE);
				feedComida.setBounds(333, 278, 127, 23);
				FeedTab.add(feedComida);
				feedComida.setEnabled(false);
				feedModa.setBackground(Color.WHITE);
				feedModa.setBounds(333, 304, 127, 23);
				FeedTab.add(feedModa);
				feedModa.setEnabled(false);
				
						feedModa.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedModa.isSelected())                            //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 5
										usuarioActual.getIntereses().setInteres(5, EstadoInteresesUsuario.INTERESADO);                  
									else
										usuarioActual.getIntereses().setInteres(5, EstadoInteresesUsuario.NO_INTERESADO);				 //Caso contrario se le quita el interes en la posicion 5
									}
								}
						});
				
						feedComida.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedComida.isSelected())                          //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 4
										usuarioActual.getIntereses().setInteres(4, EstadoInteresesUsuario.INTERESADO);                 
									else
										usuarioActual.getIntereses().setInteres(4, EstadoInteresesUsuario.NO_INTERESADO); 				 //Caso contrario se le quita el interes en la posicion 4
									}
								}
						});
				
						feedInternacional.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedInternacional.isSelected())                   //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 3
										usuarioActual.getIntereses().setInteres(3, EstadoInteresesUsuario.INTERESADO);                  
									else
										usuarioActual.getIntereses().setInteres(3, EstadoInteresesUsuario.NO_INTERESADO);				 //Caso contrario se le quita el interes en la posicion 3
									}
								}
						});
				
						feedNacional.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedNacional.isSelected())                        //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 2 
										usuarioActual.getIntereses().setInteres(2, EstadoInteresesUsuario.INTERESADO);                  
									else
										usuarioActual.getIntereses().setInteres(2, EstadoInteresesUsuario.NO_INTERESADO);				 //Caso contrario se le quita el interes en la posicion 2
									}
								}
						});
				
						feedTecnologia.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedTecnologia.isSelected())                      //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 1
										usuarioActual.getIntereses().setInteres(1, EstadoInteresesUsuario.INTERESADO);                  
									else
										usuarioActual.getIntereses().setInteres(1, EstadoInteresesUsuario.NO_INTERESADO); 				 //Caso contrario se le quita el interes en la posicion 1
									}
								}
						});
				
						feedDeporte.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e) { 
								if (nombreUsuarioActivo.getText() != "") {
									if(feedDeporte.isSelected())                         //Se revisa si esta selecionado, si es asi se agrega el interes en la posicion 0
										usuarioActual.getIntereses().setInteres(0, EstadoInteresesUsuario.INTERESADO);                  
									else
										usuarioActual.getIntereses().setInteres(0, EstadoInteresesUsuario.NO_INTERESADO);				 //Caso contrario se le quita el interes en la posicion 0
									}
								}
						});
				eliminarVistas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (nombreUsuarioActivo.getText() != "") {
							ListaFeedDesocupadoUsuario nuevoFeedDesocupado = new ListaFeedDesocupadoUsuario();
						
							for(int i = 0 ; i < usuarioActual.getFeedDesocupado().getLargo() ; i++) {
								if(usuarioActual.getFeedDesocupado().getNoticia(i).getEstado() == EstadoNoticiaUsuario.NO_VISTA) {
									nuevoFeedDesocupado.agregarNoticia(usuarioActual.getFeedDesocupado().getNoticia(i));
								}else {
									usuarioActual.getFeedEliminado().agregarEliminada(usuarioActual.getFeedDesocupado().getNoticia(i));
								}
							}
						
							usuarioActual.getFeedDesocupado().setFeed(nuevoFeedDesocupado);
						
						
							feedListaDefault = new DefaultListModel<String>();            // reiniciamos la lista de eventos
							feedLista.setModel(feedListaDefault);                         // ponemos el modelo (copiamos de la defout a la que se muestra)		
						
							for (int i = 0; i < usuarioActual.getFeedDesocupado().getLargo(); i++) {               // revisamos todos los feed que tiene el usuario en su lista feed
								feedListaDefault.addElement(usuarioActual.getFeedDesocupado().getNoticia(i).getTitulo());         // agregamos cada feed de la lista personal a la lista defoult
							}
						
						
						}
					}
				});
				borrarFeed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int seleccionIndex = feedLista.getSelectedIndex();               // se revisa si se tiene algun elemento de
																					     // la agenda selecionado
						if (seleccionIndex >= 0) {		
							usuarioActual.getFeedEliminado().agregarEliminada(usuarioActual.getFeedDesocupado().getNoticia(seleccionIndex));
							usuarioActual.getFeedDesocupado().removerNoticia(seleccionIndex);                 // lo agregamos a la lista de eventos del usuario
							feedListaDefault.removeElementAt(seleccionIndex);                        // se elimina el elemento de la lista
							feedLista.setModel(feedListaDefault);                           //ponemos el modelo

						}
					}
				});
				leerFeed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int seleccionIndex = feedLista.getSelectedIndex();               // se revisa si se tiene algun elemento de
																					     // la agenda selecionado
						if (seleccionIndex >= 0) {						
							feedListaDefault.set(seleccionIndex, "<html><font color=red>" + usuarioActual.getFeedDesocupado().getNoticia(seleccionIndex).getTitulo() + "</font></html>");   
							usuarioActual.getFeedDesocupado().getNoticia(seleccionIndex).setVista();
							try {
							    Desktop.getDesktop().browse(new URL(usuarioActual.getFeedDesocupado().getNoticia(seleccionIndex).getUrl()).toURI());
							} catch (Exception exception) {}
						}
					}
				});
		
		JPanel LlamadasTab = new JPanel();
		LlamadasTab.setBackground(Color.WHITE);
		PanelTabs.addTab("LLAMADAS", null, LlamadasTab, null);
		LlamadasTab.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(139, 11, 188, 268);
		LlamadasTab.add(scrollPane_3);
		scrollPane_3.setViewportView(llamadasLista);
		
		JButton eliminarLlamada = new JButton("ELIMINAR");
		eliminarLlamada.setBackground(Color.BLACK);
		eliminarLlamada.setBounds(139, 292, 188, 23);
		LlamadasTab.add(eliminarLlamada);
		
				JLabel tituloUsuarioActivo = new JLabel("USUARIO ACTIVO");
				tituloUsuarioActivo.setBounds(10, 11, 105, 23);
				frame.getContentPane().add(tituloUsuarioActivo);
				tituloUsuarioActivo.setHorizontalAlignment(SwingConstants.LEFT);
				nombreUsuarioActivo.setBounds(109, 11, 105, 23);
				frame.getContentPane().add(nombreUsuarioActivo);
				nombreUsuarioActivo.setHorizontalAlignment(SwingConstants.LEFT);
				
				JLabel tituloEstado = new JLabel("ESTADO");
				tituloEstado.setBounds(337, 11, 57, 23);
				frame.getContentPane().add(tituloEstado);
				tituloEstado.setHorizontalAlignment(SwingConstants.LEFT);
				estadoUsuario.setBackground(Color.WHITE);
				estadoUsuario.setForeground(Color.BLACK);
				estadoUsuario.setBounds(400, 11, 81, 23);
				frame.getContentPane().add(estadoUsuario);
				
				
				//Botones de seleccion de los gustos para el feed y estado
				estadoUsuario.setEnabled(false);
				estadoUsuario.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
							if(estadoUsuario.isSelected())                                     
								usuarioActual.setEstado(EstadoUsuario.OCUPADO);                  
							else {
								usuarioActual.setEstado(EstadoUsuario.DESOCUPADO);
								
								if(usuarioActual.getFeedOcupado().getLargo() > 0){ 
									for(int i = 0 ; i < usuarioActual.getFeedOcupado().getLargo() ; i++) {
										feedListaDefault.addElement(usuarioActual.getFeedOcupado().getNoticia(i).getTitulo());
										usuarioActual.getFeedDesocupado().agregarNoticia(usuarioActual.getFeedOcupado().getNoticia(i));
									}
									usuarioActual.getFeedOcupado().vaciarFeed();
									feedLista.setModel(feedListaDefault); 
								}
								
								if(usuarioActual.getLlamadasOcupado().getLargo() > 0){ 
									for(int i = 0 ; i < usuarioActual.getLlamadasOcupado().getLargo() ; i++) {
										String horaFechaString  = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(usuarioActual.getLlamadasOcupado().getLlamada(i).getFechaHora());  
										llamadasListaDefault.addElement("<html>" + usuarioActual.getLlamadasOcupado().getLlamada(i).getNombre() + "<br>" +  usuarioActual.getLlamadasOcupado().getLlamada(i).getNumero() + "<br>" + horaFechaString + "</html>");             
										usuarioActual.getLlamadasDesocupado().agregarLlamada(usuarioActual.getLlamadasOcupado().getLlamada(i));
									}
									usuarioActual.getLlamadasOcupado().vaciarLlamadas();
									llamadasLista.setModel(llamadasListaDefault); 			
								}
								
							}
						}
				});
				estadoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		eliminarLlamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionIndex = llamadasLista.getSelectedIndex();      // se revisa si se tiene algun elemento de
																			     // la agenda selecionado
				if (seleccionIndex >= 0) {
					
					usuarioActual.getLlamadasDesocupado().removerLlamada(seleccionIndex);                 // lo agregamos a la lista de eventos del usuario
					llamadasListaDefault.removeElementAt(seleccionIndex);   // se elimina el elemento de la lista
					llamadasLista.setModel(llamadasListaDefault);      //ponemos el modelo

				}
			}
		});
		
	}
}