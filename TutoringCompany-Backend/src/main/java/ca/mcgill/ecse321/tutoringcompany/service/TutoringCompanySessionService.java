package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.SessionType;

/**
 * 
 * @author George Kandalaft
 * 
 *
 */
@Service
public class TutoringCompanySessionService {

	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	TutoringCompanyTutorService tutorService;

	/*------- Creation methods -------*/
	/**
	 * Create Course Session with the given parameters, save it, and return it
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @param startingHour
	 * @param startingMinute
	 * @param endingHour
	 * @param endingMinute
	 * @param room
	 * @param tutor
	 * @param offering
	 * @param Set of student(s)
	 * 
	 * @exception InvalidParameterException if any of the previous integer
	 *                                      parameters is not valid.
	 * @exception NullPointerException      if tutor has no such offering
	 * @exception InvalidParameterException if tutor is not verified.
	 * 
	 * @return the created session
	 */
	@Transactional
	public Session createSession(int year, int month, int day, int startingHour, int startingMinute, int endingHour,
			int endingMinute, Room room, Tutor tutor, Offering offering, Set<Student> students) {
		sessionValid(year, month, day, startingHour, startingMinute, endingHour, endingMinute);

		if (!offering.getTutor().equals(tutor)) {
			throw new NullPointerException("Tutor " + tutor.getLast_name()
					+ "does not have this offering. Please check tutor" + offering.getTutor().getLast_name());
		}

		if (!tutor.isVerified()) {
			throw new IllegalArgumentException("Tutor is not yet verfied");
		}

		Session session = new Session();
		Date date = new Date(year - 1900, month - 1, day);

		Time startingTime = new Time(startingHour, startingMinute, 00);
		Time endingTime = new Time(endingHour, endingMinute, 00);

		session.setDate(date);
		session.setStart_time(startingTime);
		session.setEnd_time(endingTime);
		session.setOffering(offering);
		session.setRoom(room);
		session.setTutor(tutor);

		if (students.size() == 1) {
			SessionType individual = SessionType.INDIVIDUAL_SESSION;
			session.setSession_type(individual);

		} else {
			SessionType group = SessionType.PENDING_SESSION;
			session.setSession_type(group);
		}
//		Set<Student> students = new HashSet<Student>();
//		for (int i = 0; i < students.s; i++) {
//			students.add(students2[i]);
//		}
		session.setStudent(students);
		sessionRepository.save(session);
		return session;
	}

	/**
	 * Read list of sessions of the given tutor
	 *
	 * @param tutor
	 * 
	 * @return the sessions
	 */
	public List<Session> getTutorSessions(Tutor tutor) {
		List<Session> sessionsByTutor = new ArrayList<>();
		for (Session session : sessionRepository.findAll()) {
			if (session.getTutor().equals(tutor)) {
				sessionsByTutor.add(session);
			}
		}
		return sessionsByTutor;
	}

	/**
	 * Read all group sessions that are pending
	 * 
	 * @return the sessions
	 */
	public List<Session> getPendingGroupSession() {
		List<Session> pendingGroupSessions = new ArrayList<>();
		for (Session session : sessionRepository.findAll()) {
			if (session.getSession_type().equals(SessionType.PENDING_SESSION)) {
				pendingGroupSessions.add(session);
			}
		}
		return pendingGroupSessions;
	}

	/**
	 * Confirm a specific group session
	 * 
	 * @param tutor
	 * @param startingHour
	 * @param room
	 * @exception NullPointerException if tutor has no such offering
	 */
	@Transactional
	public void confirmSession(Tutor tutor, int startingHour, Room room) {
		Session s = null;
		List<Session> sessionsByTutor = getTutorSessions(tutor);
		for (Session session : sessionsByTutor) {
			if (session.getStart_time().getHours() == startingHour) {
				s = session;
			}
		}
		if (s == null) {
			throw new NullPointerException("such session doesn't exist");
		}
		if (!s.getSession_type().equals(SessionType.PENDING_SESSION)) {
			throw new NullPointerException("this session has already been approved");
		}
		s.setRoom(room);
		s.setSession_type(SessionType.GROUP_SESSION);

	}
//TODO: add month and day
	/**
	 * Delete the specific session
	 * 
	 * @param tutor
	 * @param startingHour
	 * @exception NullPointerException if tutor has no such offering
	 */
	@Transactional
	public void deleteSession(String tutorEmail, int startingHour) {
		Session session = null;
		//List<Session> sessionsByTutor = getTutorSessions(tutor);
		for (Session sessionByTutor : getTutorSessions(tutorService.getTutor(tutorEmail))) {
			if (sessionByTutor.getStart_time().getHours() == startingHour) {
				session = sessionByTutor;
			}
		}
		if (session == null) {
			throw new NullPointerException("such session doesn't exist");
		}
		sessionRepository.delete(session);
	}
	
	/**
	 * Read list of all sessions in the repository
	 * 
	 * @return list of all sessions
	 */
	@Transactional
	public List<Session> getAllSessions() {
		return (List<Session>) sessionRepository.findAll();
	}

	/**
	 * Ensures that the session info given is valid or throws exception
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param startingHour
	 * @param startingMinute
	 * @param endingHour
	 * @param endingMinute
	 * @exception InvalidParameterException if any of the given parameters are invalid (time units outside of range)
	 */
	public void sessionValid(int year, int month, int day, int startingHour, int startingMinute,
			int endingHour, int endingMinute) {
		if (year < 2019 || month > 12 || month <= 0 || day > 31 || day <= 0 || endingHour - startingHour < 0
				|| endingHour > 24 || startingHour < 00 || startingMinute < 0 || startingMinute >= 60
				|| endingMinute < 0 || endingMinute >= 60) {
			throw new InvalidParameterException("Your session details are incomplete!");
		}
	}
}