package businessLogic;
import java.util.Date;
import java.util.List;
import domain.Question;
import domain.Apuesta;

import domain.Cliente;
import domain.Event;
import domain.Trabajador;
import domain.Persona;
import domain.Pronostico;



/**
 * Interface that specifies the business logic.
 */

public interface BLFacade  {
	  

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	Question createQuestion(Event event, String question, double betMinimum);
	
	/**
	 * This method retrieves the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public List<Event> getEvents(Date date);
	
	
	public List<Date> getEventsMonth(Date date);
	
	
	//public void initializeBD();
	
	
	public Persona isLogin(String usuario, String contraseña);
	
	
	public Persona register(Persona per, String tipo);
	
	
	public void createEvent(String description, Date eventDate);
	
	public List<Question> getQuestions(Event event);
}