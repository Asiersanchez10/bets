package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Cliente;

public class ClienteGUI extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 6458065498915389023L;
	private JPanel contentPane;
	private MainGUI primerMain;
	private Cliente cliente;

	public ClienteGUI(Cliente cliente, MainGUI primerMain) {
		try {
			this.primerMain = primerMain;
			this.cliente=cliente;
			clienteGUIEjecucion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clienteGUIEjecucion() throws Exception {
		
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("Customer"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Welcome")+" "+cliente.getUsuario()+"!"); //$NON-NLS-1$ //$NON-NLS-2$
		lblNewLabel.setBounds(123, 0, 250, 29);
		contentPane.add(lblNewLabel);

		JButton SignOut = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SignOut")); //$NON-NLS-1$ //$NON-NLS-2$
		SignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarSesion();
			}
		});
		SignOut.setBounds(16, 427, 140, 23);
		contentPane.add(SignOut);
		
		JButton btnMakeABet = new JButton();
		btnMakeABet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirHacerApuesta();
			}
		});
		btnMakeABet.setText(ResourceBundle.getBundle("Etiquetas").getString("btnMakeABet")); //$NON-NLS-1$ //$NON-NLS-2$
		btnMakeABet.setBounds(16, 25, 408, 40);
		contentPane.add(btnMakeABet);
		
		JButton btnDeleteABet = new JButton();
		btnDeleteABet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirBorrarApuesta();
			}
		});
		btnDeleteABet.setText(ResourceBundle.getBundle("Etiquetas").getString("btnDeleteABet")); //$NON-NLS-1$ //$NON-NLS-2$
		btnDeleteABet.setBounds(16, 64, 408, 40);
		contentPane.add(btnDeleteABet);
		
		JButton btnDinero = new JButton();
		btnDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirMeterDinero();
			}
		});
		btnDinero.setText(ResourceBundle.getBundle("Etiquetas").getString("btnDirua")); //$NON-NLS-1$ //$NON-NLS-2$
		btnDinero.setBounds(16, 103, 408, 40);
		contentPane.add(btnDinero);
		
		JButton btnHistorialDinero = new JButton();
		btnHistorialDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirMovimientoDinero();
			}
		});
		btnHistorialDinero.setText(ResourceBundle.getBundle("Etiquetas").getString("btnHistorialDinero")); //$NON-NLS-1$ //$NON-NLS-2$
		btnHistorialDinero.setBounds(16, 142, 408, 40);
		contentPane.add(btnVerMovimientosDinero);
		
		JButton btnQueryQuestions = new JButton();
		btnQueryQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a = new FindQuestionsGUI();
				a.setVisible(true);
			}
		});
		btnQueryQuestions.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries")); //$NON-NLS-1$ //$NON-NLS-2$
		btnQueryQuestions.setBounds(16, 181, 408, 40);
		contentPane.add(btnQueryQuestions);
		
		
	}

	/**
	 * Con este metodo cerramos sesion y volvemos al inicio
	 */
	public void cerrarSesion() {
		this.setVisible(false);
		this.primerMain.setVisible(true);
	}
	
	public void abrirHacerApuesta() {
		this.setVisible(false);
		JFrame a = new HacerApuestaGUI(this, cliente);
		a.setVisible(true);
	}
	
	public void abrirBorrarApuesta() {
		this.setVisible(false);
		JFrame a = new BorrarApuestaGui(this, cliente);
		a.setVisible(true);
	}
	
	public void abrirMeterDinero() {
		this.setVisible(false);
		JFrame a = new MeterDineroGui(cliente, this);
		a.setVisible(true);
	}
	
	public void abrirHsitorialDinero() {
		this.setVisible(false);
		JFrame a = new AbrirHistorialDineroGUI(cliente, this);
		a.setVisible(true);
	}
	
	
	
	
	public void irekiEzarpenak() {
		this.setVisible(false);
		JFrame a = new EzarpenakAldatuGUI(bezeroa, this);
		a.setVisible(true);
	}

	
	
	public void setCliente(Cliente b) {
		this.cliente=b;
	}
}