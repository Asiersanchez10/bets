package gui;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Cliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class MeterDineroGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Cliente cliente;
	private ClienteGUI primero;
	private JLabel jlblError;
	private JLabel jlblSucces;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public MeterDineroGUI(Cliente cliente, ClienteGUI primero) {
		try {
			this.primero=primero;
			this.cliente=cliente;
			DiruaSartuGUIExekuzioa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public void DiruaSartuGUIExekuzioa() {
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("PutMoneyGUI"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.BLACK);
		textField.setBounds(302, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel Cuantia = new JLabel();
		Cuantia.setText(ResourceBundle.getBundle("Etiquetas").getString("Cuantia")); //$NON-NLS-1$ //$NON-NLS-2$
		Cuantia.setBounds(39, 62, 241, 28);
		contentPane.add(Cuantia);
		
		BLFacade facade=MainGUI.getBusinessLogic();
		JButton btnDiruaSartu = new JButton(ResourceBundle.getBundle("Etiquetas").getString("btnDiruaSartu")); //$NON-NLS-1$ //$NON-NLS-2$
		btnDiruaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jlblSucces.setText("");
				jlblError.setText("");
				try {
					double zenb= Double.valueOf(textField.getText());
					if (zenb>1) {
						cliente = facade.MeterDinero(zenb, cliente);
						jlblSucces.setText(ResourceBundle.getBundle("Etiquetas").getString("SuccessMoney"));
					}else {
						jlblError.setText(ResourceBundle.getBundle("Etiquetas").getString("SartuMinimo"));
					}
				} catch(Exception e) {
					jlblError.setText(ResourceBundle.getBundle("Etiquetas").getString("InvalidSyntax"));
				}
				
				
			}
		});
		btnDiruaSartu.setBounds(142, 175, 157, 23);
		contentPane.add(btnDiruaSartu);
		
		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close")); //$NON-NLS-1$ //$NON-NLS-2$
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atras();
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPane.add(btnClose);
		
		jlblError = new JLabel("");
		jlblError.setForeground(Color.RED);
		jlblError.setBounds(50, 113, 347, 20);
		contentPane.add(jlblError);
		
		jlblSucces = new JLabel("");
		jlblSucces.setForeground(Color.GREEN);
		jlblSucces.setBounds(69, 113, 314, 20);
		contentPane.add(jlblSucces);
		
		lblNewLabel = new JLabel("\u20AC");
		lblNewLabel.setBounds(392, 69, 13, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void atras() {
		this.setVisible(false);
		this.primero.setCliente(cliente);
		this.primero.setVisible(true);
	}
}

