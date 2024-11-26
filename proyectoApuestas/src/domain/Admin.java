package domain;

import java.io.Serializable;
import java.util.Date;

public class Admin extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Admin(){
		super();
	}

	public Admin(String nombre, String apellido1, String apellido2, String nombreUsuario, String contraseña, String telefono, String email, Date fechaNacimiento) {
		super(nombre, apellido1, apellido2, nombreUsuario, contraseña, telefono, email, fechaNacimiento);
	}
}
