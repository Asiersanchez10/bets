package domain;

import java.io.Serializable;
import java.util.Vector;
import java.util.Date;
import java.util.Vector;


public class Cliente extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double dinero;
	private Integer jugados;
	private Integer ganados;
	private double comisionAutomatica;
	
	private Vector<Movimiento> movimientos=new Vector<Movimiento>();
	
	private Vector<Apuesta> apuestas=new Vector<Apuesta>();
	
	
	public Cliente(){
		super();
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public void setMovimientos(Vector<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Cliente(String nombre, String apellido1, String apellido2, String usuario, String contraseña, String telefono, String email, Date fechaNacimiento) {
		super(nombre, apellido1, apellido2, usuario, contraseña, telefono, email, fechaNacimiento);
		this.dinero=0;
		jugados=0;
		ganados=0;
		comisionAutomatica=-1;
	}
	
	public Movimiento addMovimiento(String descripcion, double cuota, String tipo) {
		ActualizarDinero(cuota);
		Movimiento nuevo = new Movimiento(descripcion, cuota, this, tipo);
		movimientos.add(nuevo);
		return nuevo;
	}
	
	public Movimiento addMovimiento(String descripcion, double cuota, String tipo, Date data) {
		ActualizarDinero(cuota);
		Movimiento nuevo = new Movimiento(descripcion, cuota, this, tipo, data);
		movimientos.add(nuevo);
		if(tipo=="ganar") {
			ganados++;
		}
		return nuevo;
	}
	
	public void ActualizarDinero(double cantidad) {
		dinero=cantidad;
	}
	
	public double getDinero() {
		return dinero;
	}
	
	
	
	public Apuesta addApuesta(double dinero, Cliente quien, Vector<Pronostico> pronosticos) {
		Apuesta nueva = new Apuesta(dinero, quien, pronosticos);
		apuestas.add(nueva);
		jugados=jugados+1;
		return nueva;
	
	}
	
	public void removeApuesta(Apuesta apuesta) {
		this.apuestas.remove(apuesta);
		jugados=jugados-1;
	}
	
	public Vector<Apuesta> getApuestas(){
		return apuestas;
	}
	
	public Vector<Double> getInformacionBeneficio(){
		Vector<Double> resultado = new Vector<Double>();
		double ganado, jugado, beneficio;
		ganado=0;
		jugado=0;
		for(Movimiento movimiento : movimientos) {
			if(movimiento.getTipo().equals("ganar")) {
				ganado+=movimiento.getCambio();
			} else
				jugado = getJugado(jugado, movimiento);
		}
		beneficio=ganado-jugado;
		resultado.add(jugado);
		resultado.add(ganado);
		resultado.add(beneficio);
		return resultado;
	}

	private double getJugado(double jugado, Movimiento movimiento) {
		if(movimiento.getTipo().equals("devolver")) {
			jugado-=movimiento.getCambio();
		}else if(movimiento.getTipo().equals("jugar")){
			jugado-=movimiento.getCambio();
		}
		return jugado;
	}

	public Integer getJugados() {
		return jugados;
	}

	public void setJugados(Integer jugados) {
		this.jugados = jugados;
	}

	public Integer getganados() {
		return ganados;
	}

	public void setGanados(Integer ganados) {
		this.ganados = ganados;
	}
	
	public String toString() {
		return usuario;
	}
	

	public double getComisionAutomatica() {
		return comisionAutomatica;
	}

	public void setComisionAutomatica(double comisionAutomatica) {
		this.comisionAutomatica = comisionAutomatica;
	}

	public String getUsuario() {
		// TODO Auto-generated method stub
		return usuario;
	}
	
	

	
	
	}
