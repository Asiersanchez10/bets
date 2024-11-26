package domain;

import java.io.Serializable;
import java.util.Vector;




public class Pronostico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private double cuota;
	private Integer identificador;
	private Question question;
	
	private Vector<Apuesta> apuestas=new Vector<Apuesta>();
	
	public Pronostico(){
		super();
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setKuota(double cuota) {
		this.cuota = cuota;
	}

	public void setIdentifikadorea(Integer identificador) {
		this.identificador = identificador;
	}

	public void setApuestas(Vector<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	

	public Pronostico(String descripcion, double cuota) {
		this.descripcion = descripcion;
		this.cuota = cuota;
	}

	public Pronostico(String descripcion, double cuota, Question question) {
		this.descripcion = descripcion;
		this.cuota = cuota;
		this.question = question;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getcuota() {
		return cuota;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
	
	public Vector<Apuesta> getApuestas(){
		return apuestas;
	}
	
	public String toString() {
		return descripcion + " : " + cuota;
	}
	
	public void addApustua(Apuesta apuesta) {
		apuestas.add(apuesta);
	}
	
	public void removeApuesta(Apuesta a) {
		this.apuestas.remove(a);
	}
	
	public boolean equals(Pronostico p) {
		return p.descripcion.equals(this.descripcion) && p.question.getQuestionNumber()==question.getQuestionNumber();
	}
}
