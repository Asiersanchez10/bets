package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;




public class Trabajador extends Persona implements Serializable{
	
	

	
	private static final long serialVersionUID = 1L;
	
	public Trabajador(){
		super();
	}

	public Trabajador(String nombre, String apellido1, String apellido2, String usuario, String contraseña, String telefono, String email, Date fechaNacimiento) {
		super(nombre, apellido1, apellido2, usuario, contraseña, telefono, email, fechaNacimiento);
	}
	

}