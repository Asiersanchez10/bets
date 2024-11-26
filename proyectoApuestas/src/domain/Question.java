package domain;

import java.io.*;
import java.util.Vector;
import java.util.Vector;



public class Question implements Serializable {
	
	
	private Integer questionNumber;
	private String question; 
	private double betMinimum;
	private String result;  
	
	private Event event;
	
	private Vector<Pronostico> pronosticos=new Vector<Pronostico>();

	public Question(){
		super();
	}
	
	public Question(Integer queryNumber, String query, double betMinimum, Event event) {
		super();
		this.questionNumber = queryNumber;
		this.question = query;
		this.betMinimum=betMinimum;
		this.event = event;
	}
	
	public Question(String query, double betMinimum,  Event event) {
		super();
		this.question = query;
		this.betMinimum=betMinimum;
		this.event = event;
	}

	/**
	 * Get the  number of the question
	 * 
	 * @return the question number
	 */
	public Integer getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * Set the bet number to a question
	 * 
	 * @param questionNumber to be setted
	 */
	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}


	/**
	 * Get the question description of the bet
	 * 
	 * @return the bet question
	 */

	public String getQuestion() {
		return question;
	}


	/**
	 * Set the question description of the bet
	 * 
	 * @param question to be setted
	 */	
	public void setQuestion(String question) {
		this.question = question;
	}



	/**
	 * Get the minimun ammount of the bet
	 * 
	 * @return the minimum bet ammount
	 */
	
	public double getBetMinimum() {
		return betMinimum;
	}


	/**
	 * Get the minimun ammount of the bet
	 * 
	 * @param  betMinimum minimum bet ammount to be setted
	 */

	public void setBetMinimum(double betMinimum) {
		this.betMinimum = betMinimum;
	}



	/**
	 * Get the result of the  query
	 * 
	 * @return the the query result
	 */
	public String getResult() {
		return result;
	}



	/**
	 * Get the result of the  query
	 * 
	 * @param result of the query to be setted
	 */
	
	public void setResult(String result) {
		this.result = result;
	}



	/**
	 * Get the event associated to the bet
	 * 
	 * @return the associated event
	 */
	public Event getEvent() {
		return event;
	}


	/**
	 * Set the event associated to the bet
	 * 
	 * @param event to associate to the bet
	 */
	public void setEvent(Event event) {
		this.event = event;
	}




	public String toString(){
		return question;
	}
	
	
	public Pronostico addPronostico(String descripcion, double cuota) {
		Pronostico nuevo = new Pronostico(descripcion, cuota, this);
		pronosticos.add(nuevo);
		return nuevo;
	}
	
	public Vector<Pronostico> getPronostico(){
		return pronosticos;
	}

	public boolean doesPronosticExists(String descripcion)  {	
		for (Pronostico p:this.getPronostico()){
			if (p.getDescripcion().compareTo(descripcion)==0)
				return true;
		}
		return false;
	}
	
}