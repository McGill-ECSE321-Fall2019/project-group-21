package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanySessionService;

import org.junit.Test;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSession {

	@Autowired
	private TutoringCompanySessionService SessionService;

	@Autowired
	private SessionRepository sessionRepository;
	
//	@Before
//	public void clearDatabase() {
//		sessionRepository.deleteAll();
//	}
	
	/**
	 * Create a session
	 * @result Session will be persisted without any errors
	 */
	@Test
	public void testCreateSession() {
		assertEquals(0, SessionService.getAllSessions().size());
		
		Room room = new Room();
		Tutor tutor = new Tutor();
		Offering offering = new Offering();
		Set<Student> students = new HashSet<Student>();
		
		int year = 2000;
		
		try {
			SessionService.createSession(year, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Session> allSessions = SessionService.getAllSessions();
		assertEquals(1, allSessions.size());
		assertEquals(year, allSessions.get(0).getDate().getYear());
	}
	
	/**
	 * Create a session with a null name
	 * @result Session will not be created due to an error
	 */
	@Test
	public void testCreateSessionNull() {
		assertEquals(0, SessionService.getAllSessions().size());
		
		Room room = null;
		Tutor tutor = new Tutor();
		Offering offering = new Offering();
		Set<Student> students = new HashSet<Student>();
		
		String error = null;
		
		try {
			SessionService.createSession(2000, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your session details are incomplete!", error);
		assertEquals(0, SessionService.getAllSessions().size());
	}
	
	/**
	 * Delete a session
	 * @result Session will be deleted without any errors
	 */
	@Test
	public void testDeleteSession() {
		assertEquals(0, SessionService.getAllSessions().size());
		
		Room room = new Room();
		Tutor tutor = new Tutor();
		Offering offering = new Offering();
		Set<Student> students = new HashSet<Student>();
		
		SessionService.createSession(2000, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
		
		assertEquals(1, SessionService.getAllSessions().size());
		try {
			SessionService.deleteSession(tutor,1);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, SessionService.getAllSessions().size());
	}
}
