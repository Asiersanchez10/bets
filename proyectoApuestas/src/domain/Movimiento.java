package domain;

import java.io.Serializable;
import java.util.Date;

public class Movimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private Date fecha;
	private double Cambio;

	
	private Integer identificador;
	private Cliente cliente;
	private String tipo;
	
	public Movimiento(){
		super();
	}
	
	public Movimiento(String descripcion, double cambio, String tipo) {
		fecha=new Date();
		this.descripcion = descripcion;
		this.Cambio = cambio;
		this.tipo = tipo;
	}
	
	public Movimiento(String descripcion, double cambio, Cliente cliente, String tipo) {
		fecha=new Date();
		this.descripcion = descripcion;
		this.Cambio = cambio;
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCambio(double cambio) {
		this.Cambio = cambio;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Movimiento(String descripcion, double cambio, Cliente cliente, String tipo, Date fecha) {
		this.fecha=fecha;
		this.descripcion = descripcion;
		this.Cambio = cambio;
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public double getCambio() {
		return Cambio;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String toString() {
		return fecha+" : "+descripcion+"  /  "+Cambio+ " �";
	}
}
