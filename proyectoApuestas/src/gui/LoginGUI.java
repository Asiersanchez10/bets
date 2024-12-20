package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.BLFacade;
import domain.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

import domain.Admin;
import domain.Cliente;
import domain.Trabajador;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5720904581861757676L;
	private JPanel contentPane;
	private JTextField UserName;
	private JPasswordField password;
	private MainGUI primerMain;
	private JLabel NotAcount;
	private JLabel mensajeError;
	
	
	public LoginGUI(MainGUI primero) {
		try {
			this.primerMain=primero;
			loginGUIEjecucion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loginGUIEjecucion() throws Exception{
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("LoginGUI"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("lblUserName")); //$NON-NLS-1$ //$NON-NLS-2$
		lblUserName.setBounds(21, 29, 84, 14);
		contentPane.add(lblUserName);
		
		UserName = new JTextField();
		UserName.setBounds(115, 26, 148, 20);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(115, 57, 148, 20);
		contentPane.add(password);
		
		JLabel lblPassword = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("lblPassword")); //$NON-NLS-1$ //$NON-NLS-2$
		lblPassword.setBounds(21, 60, 84, 14);
		contentPane.add(lblPassword);
		
		JButton logIn = new JButton(ResourceBundle.getBundle("Etiquetas").getString("logIn")); //$NON-NLS-1$ //$NON-NLS-2$
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mensajeError.setText("");
				String user= UserName.getText();
				String pas = new String(password.getPassword());
				BLFacade facade = MainGUI.getBusinessLogic();
				Persona persona = facade.isLogin(user,pas);
				if(persona instanceof Trabajador) {
					loginTrabajador((Trabajador)persona);
				}else if(persona instanceof Admin) {
					loginAdmin((Admin)persona);
				}else if(persona instanceof ClienteGui) {
					loginCliente((Bezeroa)persona);
				}else {
					mensajeError.setText(ResourceBundle.getBundle("Etiquetas").getString("IncorrectPass"));
				}
			}
		});
		logIn.setBounds(162, 113, 89, 39);
		contentPane.add(logIn);
		
		JButton register = new JButton(ResourceBundle.getBundle("Etiquetas").getString("register")); //$NON-NLS-1$ //$NON-NLS-2$
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irekiRegister();
			}
		});
		register.setBounds(270, 211, 139, 39);
		contentPane.add(register);
		
		NotAcount = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("NotAcount")); //$NON-NLS-1$ //$NON-NLS-2$
		NotAcount.setBounds(220, 193, 224, 14);
		contentPane.add(NotAcount);
		
		JButton btnNewButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("btnNewButton")); //$NON-NLS-1$ //$NON-NLS-2$
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bueltatuMain();
			}
		});
		btnNewButton.setBounds(26, 211, 79, 39);
		contentPane.add(btnNewButton);
		
		mensajeError = new JLabel("");
		mensajeError.setBounds(52, 88, 333, 14);
		mensajeError.setForeground(Color.RED);
		contentPane.add(mensajeError);
	}
	
	/**
	 * Metodo honen bidez, uneko interfazea itxi eta aurrekoa (main) irekitzen da
	 */
	public void volverMain() {
		this.setVisible(false);
		this.primerMain.setVisible(true);
	}
	
	/**
	 * Metodo honen bidez, uneko interfazea itxi eta register interfazea irekitzen da
	 */
	public void abrirRegister() {
		this.setVisible(false);
		JFrame a = new RegisterGUI(this.primerMain,this);
		a.setVisible(true);
	}
	
	/**
	 * Metodo honek langile baten interfazean sartzeko balio du
	 * @param langilea
	 */
	public void loginTrabajador(Trabajador trabajador) {
		this.setVisible(false);
		JFrame a = new TrabajadorGUI(trabajador,this.primerMain);
		a.setVisible(true);
	}
	
	/**
	 * Metodo honek administradore baten interfazean sartzeko balio du
	 * @param admin
	 */
	public void loginAdmin(Admin admin) {
		this.setVisible(false);
		JFrame a = new AdminGUI(admin,this.primerMain);
		a.setVisible(true);
	}
	
	/**
	 * Metodo honek bezero baten interfazean sartzeko balio du.
	 * @param bezeroa
	 */
	public void loginCliente(ClienteGui cliente) {
		this.setVisible(false);
		JFrame a = new ClienteGUI(cliente,this.primerMain);
		a.setVisible(true);
	}
}

