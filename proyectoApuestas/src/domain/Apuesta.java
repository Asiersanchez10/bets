package domain;

import java.io.Serializable;
import java.util.Vector;

public class Apuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double cantidad;
	private Integer identificador;
	private Cliente cliente;
	private Vector<Pronostico> pronosticos=new Vector<Pronostico>();
	private Integer NumeroDePronosticos;
	private Integer acertadas;
	private double cuotaTotal;
	private Apuesta apuesta;
	
	public Apuesta(){
		super();
	}
	
	public Apuesta(double cantidad, Cliente cliente, Vector<Pronostico> pronosticos) {
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.pronosticos = pronosticos;
		this.NumeroDePronosticos = pronosticos.size();
		acertadas=0;
		double cuota = 1;
		for(Pronostico p : pronosticos) {
			cuota=cuota*p.getcuota();
		}
		cuotaTotal=cuota;

	}
	
	public Integer getNumeroDePronosticos() {
		return NumeroDePronosticos;
	}

	public void setNumeroDePronosticos(Integer numeroDePronosticos) {
		this.NumeroDePronosticos = numeroDePronosticos;
	}

	public Integer getAcertadas() {
		return acertadas;
	}

	public void setAcertadas(Integer acertadas) {
		this.acertadas = acertadas;
	}

	public double getCuota() {
		return cuotaTotal;
	}

	public void setCuota(double cuotaTotal) {
		this.cuotaTotal = cuotaTotal;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setIdentifikadorea(Integer identificador) {
		this.identificador = identificador;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setPronostico(Vector<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	}

	public Apuesta(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Vector<Pronostico> getPronosticos() {
		return pronosticos;
	}
	

	
	public int removePronostico(Pronostico p) {
		NumeroDePronosticos--;
		cuotaTotal=cuotaTotal/p.getcuota();
		this.pronosticos.remove(p);
		return NumeroDePronosticos;
	}
	
	public boolean ActualizarAcertads() {
		acertadas=acertadas+1;
		System.out.println(acertadas+"=="+NumeroDePronosticos);
		return acertadas==NumeroDePronosticos;
	}

	
	

	
	public boolean tienePronostico(Pronostico pronos) {
		for(Pronostico p : pronosticos) {
			if(pronos.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public Apuesta getApuesta() {
		return apuesta;
	}
	public void setApuesta(Apuesta apuesta) {
		this.apuesta = apuesta;
	}
}
