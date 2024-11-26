package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Trabajador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class TrabajadorGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5173883962843347204L;
	private JPanel contentPane;
	private MainGUI primerMain;
	private Trabajador trabajador;

	public TrabajadorGUI(Trabajador trabajador, MainGUI primerMain) {
		try {
			this.primerMain=primerMain;
			this.trabajador=trabajador;
			trabajadorGUIEjecucion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void trabajadorGUIEjecucion() throws Exception{
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("Worker"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Welcome")+" "+trabajador.getUsuario()+"!"); //$NON-NLS-1$ //$NON-NLS-2$
		lblNewLabel.setBounds(124, 23, 250, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SignOut"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarSesion();
			}
		});
		btnNewButton.setBounds(16, 390, 179, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCreateEvent = new JButton();
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCreateEvent();
			}
		});
		btnCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateEvent"));
		btnCreateEvent.setBounds(16, 49, 408, 66);
		contentPane.add(btnCreateEvent);
		
		JButton btnCreatePronostic = new JButton();
		btnCreatePronostic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCreatePronostic();
			}
		});
		btnCreatePronostic.setText(ResourceBundle.getBundle("Etiquetas").getString("CreatePronostic"));
		btnCreatePronostic.setBounds(16, 115, 408, 66);
		contentPane.add(btnCreatePronostic);
		
		JButton btnPutResult = new JButton();
		btnPutResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirPonerResultado();
			}
		});
		btnPutResult.setText(ResourceBundle.getBundle("Etiquetas").getString("PutResult"));
		btnPutResult.setBounds(16, 182, 408, 66);
		contentPane.add(btnPutResult);
		
		JButton btnDeleteEvent = new JButton();
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirBorrarEvento();
			}
		});
		
	}
	
	/**
	 * Metodo honen bidez gertaera sortu erabilera kasuaren interfazea irekitzen da
	 */
	public void abrirCreateEvent() {
		this.setVisible(false);
		JFrame a = new CreateEventGUI(this);
		a.setVisible(true);
	}
	
	public void abrirCreatePronostic() {
		this.setVisible(false);
		JFrame a = new CreatePronosticGUI(this);
		a.setVisible(true);
	}
	
	public void irekiEmaitzaIpini() {
		this.setVisible(false);
		JFrame a = new PonerResultadoGUI(this);
		a.setVisible(true);
	}
	
	public void abrirBorrarEvento() {
		this.setVisible(false);
		JFrame a = new BorrarEventoGUI(this);
		a.setVisible(true);
	}
	
	
	
	public void setTrabajador(Trabajador l) {
		this.trabajador=l;
	}
	
	/**
	 * Metodo honen bidez, saioa itxi eta hasierako menura joaten gara
	 */
	public void cerrarSesion() {
		this.setVisible(false);
		this.primerMain.setVisible(true);
	}
}
