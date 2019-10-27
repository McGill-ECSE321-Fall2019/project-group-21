package ca.mcgill.ecse321.tutoringcompany.service;

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
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
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
	 * @param sessionType
	 * @param room
	 * @param tutor
	 * @param offering
	 * @param student(s)
	 * 
	 * @return the created session
	 */
	@Transactional
	public Session createSession(int year, int month, int day, int startingHour, int startingMinute, int endingHour,
			int endingMinute, Room room, Tutor tutor, Offering offering, Student ...student) {
		Session session = new Session();
		Date date = new Date(year, month, day);

		Time startingTime = new Time(startingHour, startingMinute, 00);
		Time endingTime = new Time(endingHour, endingMinute, 00);
		
		session.setDate(date);
		session.setStart_time(startingTime);
		session.setEnd_time(endingTime);
		session.setOffering(offering);
		session.setRoom(room);
		session.setTutor(tutor);
		
		//TODO: Exception if student.length < 1
		
		if (student.length == 1) {
			SessionType individual = SessionType.INDIVIDUAL_SESSION;
			session.setSession_type(individual);
			}
		else {
			SessionType group = SessionType.GROUP_SESSION;
			session.setSession_type(group);
		}
		Set<Student> students = new HashSet<Student>();
		for (int i=0; i<student.length; i++) {
			students.add(student[i]);
		}
		session.setStudent(students);
		sessionRepository.save(session);
		return session;
	}
	@Transactional
	public List<Session> getAllSessions() {
		return (List<Session>) sessionRepository.findAll();
	}
}
