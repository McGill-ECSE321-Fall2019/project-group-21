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
import ca.mcgill.ecse321.tutoringcompany.model.*;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
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
	@Autowired
	private TutoringCompanyRoomService RoomService;
	@Autowired
	private TutoringCompanyOfferingService OfferingService;
	@Autowired
	private TutoringCompanyStudentService StudentService;
	@Autowired
	private TutoringCompanyTutorService TutorService;
	@Autowired
	private TutoringCompanyCourseService CourseService;
	@Autowired
	private TutoringCompanyManagerService ManagerService;


	
	@Before
	public void clearDatabase() {
		sessionRepository.deleteAll();
//		StudentService.createStudent("george", "tamraz", "st1@gmail.com", "1234567890", "123456");
//		TutorService.createTutor("elias", "tamraz", "tut1@gmail.com", "4389883384", "50000");
//		TutorService.getTutor("tut1@gmail.com").setVerified(true);
		
	}
	
	/**
	 * Create a session
	 * @result Session will be persisted without any errors
	 */
	@Test
	public void testCreateSession() {
		
		assertEquals(0, SessionService.getAllSessions().size());
		Set<Student> students = new HashSet<Student>();
		Student s = StudentService.getstudent("st1@gmail.com");
		students.add(s);
		Tutor t = TutorService.getTutor("tut1@gmail.com");
		Room r = RoomService.getRoom(12);
		Offering o =  OfferingService.getSpecificOffering(21);
	
		
		int year = 2019;
		
		try {
			SessionService.createSession(year, 11, 23, 13, 0, 14, 0, r, t,o ,students);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Session> allSessions = SessionService.getAllSessions();
		assertEquals(1, allSessions.size());
		//assertEquals(year, allSessions.get(0).getDate().getYear());
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
		
		String error ="";
		
		try {
			SessionService.createSession(2000, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your session details are incomplete!", error);
		assertEquals(0, SessionService.getAllSessions().size());
	}
//	
//	/**
//	 * Delete a session
//	 * @result Session will be deleted without any errors
//	 */
//	@Test
//	public void testDeleteSession() {
//		assertEquals(0, SessionService.getAllSessions().size());
//		
//		Room room = new Room();
//		Tutor tutor = new Tutor();
//		Offering offering = new Offering();
//		Set<Student> students = new HashSet<Student>();
//		
//		SessionService.createSession(2000, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
//		
//		assertEquals(1, SessionService.getAllSessions().size());
//		try {
//			SessionService.deleteSession(tutor,1);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		assertEquals(0, SessionService.getAllSessions().size());
//	}
}
