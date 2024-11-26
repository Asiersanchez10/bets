package domain;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String apellido1;
	public String apellido2;
	/*añadir a base de datos*/
	public String usuario;
	public String contraseña;
	public String telefono;
	public String email;
	public Date fechaNacimiento;
	
	public Persona(){
		super();
	}
	
	public Persona (String nombre, String apellido1, String apellido2, String usuario, String contraseña, String telefono, String email, Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.email=email;
		this.fechaNacimiento=fechaNacimiento;
	}
	
	public String getErabiltzaileIzena() {
		return usuario;
	}

	public String getIzena() {
		return nombre;
	}

	public void setIzena(String izena) {
		this.nombre = izena;
	}

	public String getAbizena1() {
		return apellido1;
	}

	public void setAbizena1(String abizena1) {
		this.apellido1 = abizena1;
	}

	public String getAbizena2() {
		return apellido2;
	}

	public void setAbizena2(String abizena2) {
		this.apellido2 = abizena2;
	}

	public String getPasahitza() {
		return contraseña;
	}

	public void setPasahitza(String pasahitza) {
		this.contraseña = pasahitza;
	}

	public String getTelefonoZbkia() {
		return telefono;
	}

	public void setTelefonoZbkia(String telefonoZbkia) {
		this.telefono = telefonoZbkia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date FechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.usuario = erabiltzaileIzena;
	}
	

}
