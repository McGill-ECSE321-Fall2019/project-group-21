package ca.mcgill.ecse321.tutoringcompany.dto;

import java.util.Collections;
import java.util.Set;

import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

public class OfferingDto {

	private int price_individual, price_group, id;
	private Tutor tutor;
	private Course course;
	// private Set<Session> sessions;

//	@SuppressWarnings("unchecked")
//	public OfferingDto(int price_individual, int price_group, int id, Tutor tutor, Course course) {
//		this(price_individual, price_group, id, tutor, course, Collections.EMPTY_SET);
//	}

	public OfferingDto(int price_individual, int price_group, int id, Tutor tutor, Course course) {
		this.price_individual = price_individual;
		this.price_group = price_group;
		this.id = id;
		this.tutor = tutor;
		this.course = course;
		// this.sessions = sessions;
	}

	public int getPrice_individual() {
		return price_individual;
	}

	public void setPrice_individual(int price_individual) {
		this.price_individual = price_individual;
	}

	public int getPrice_group() {
		return price_group;
	}

	public void setPrice_group(int price_group) {
		this.price_group = price_group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

//	public Set<Session> getSessions() {
//		return sessions;
//	}

//	public void setSessions(Set<Session> sessions) {
//		this.sessions = sessions;
//	}
//	
	/*
	 * @param session to add to the Set of sessions
	 * 
	 * @return boolean of whether the sessions Set did not already contain the
	 * specified element (true if successfully added)
	 */
//	public boolean addSession(Session session) {
//		return this.sessions.add(session);
//	}

	/*
	 * @param session to remove from the Set of sessions
	 * 
	 * @return whether the sessions Set contained the element (if the sessions Set
	 * changed as a result of the call)
	 */
//	public boolean removeSession(Session session) {
//		return this.sessions.remove(session);
//	}
}