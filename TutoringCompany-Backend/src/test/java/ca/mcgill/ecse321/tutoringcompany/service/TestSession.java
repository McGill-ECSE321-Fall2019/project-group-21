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

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
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
	private TutoringCompanySessionService sessionService;

	@Autowired
	private TutoringCompanyRoomService roomService;

	@Autowired
	private TutoringCompanyTutorService tutorService;

	@Autowired
	private TutoringCompanyOfferingService offeringService;

	@Autowired
	private TutoringCompanyCourseService courseService;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private RoomTimeBlockRepository roomTimeBlockRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private TutorReviewsRepository tutorReviewsRepository;

	@Autowired
	private OfferingRepository offeringRepository;

	@Autowired
	private TutorTimeBlockRepository tutorTimeBlockRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Before
	public void clearDatabase() {
		sessionRepository.deleteAll();

		roomTimeBlockRepository.deleteAll();
		roomRepository.deleteAll();

		tutorTimeBlockRepository.deleteAll();
		offeringRepository.deleteAll();
		tutorReviewsRepository.deleteAll();
		tutorRepository.deleteAll();

		courseRepository.deleteAll();
	}

	/**
	 * Create a session
	 * 
	 * @result Session will be persisted without any errors
	 */
	@Test
	public void testCreateSession() {
		assertEquals(0, sessionService.getAllSessions().size());

		Room room = null;
		Tutor tutor = null;
		Offering offering = null;
		Course course = null;

		try {
			course = courseService.createCourse("name", Subject.MATH, "ecse321");
			room = roomService.createRoom(123, RoomType.INDIVIDUAL_ROOM);
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			tutor = tutorService.verifyTutor("mail@mail.com");
			offering = offeringService.createOffering(20, 25, course, tutor);
		} catch (IllegalArgumentException e) {
			fail();
		}

		Set<Student> students = new HashSet<Student>();

		int year = 2019;
		int month = 4;
		try {
			sessionService.createSession(year, month, 30, 1, 1, 23, 59, room, tutor, offering, students);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Session> allSessions = sessionService.getAllSessions();
		assertEquals(1, allSessions.size());
		assertEquals(year, allSessions.get(0).getDate().getYear() + 1900);
		assertEquals(month, allSessions.get(0).getDate().getMonth() + 1);
	}

	/**
	 * Create a session with a null name
	 * 
	 * @result Session will not be created due to an error
	 */
	@Test
	public void testCreateSessionNull() {
		assertEquals(0, sessionService.getAllSessions().size());

		Course course = null;
		Room room = null;
		Tutor tutor = null;
		Offering offering = null;

		try {
			course = courseService.createCourse("name", Subject.MATH, "ecse321");
			room = roomService.createRoom(123, RoomType.INDIVIDUAL_ROOM);
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			tutor = tutorService.verifyTutor("mail@mail.com");
			offering = offeringService.createOffering(20, 25, course, tutor);
		} catch (IllegalArgumentException e) {
			fail();
		}

		Set<Student> students = new HashSet<Student>();

		String error = null;

		try {
			sessionService.createSession(2000, 12, 30, 1, 0, 23, 59, room, tutor, offering, students);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your session details are incomplete!", error);
		assertEquals(0, sessionService.getAllSessions().size());
	}

	/**
	 * Delete a session
	 * 
	 * @result Session will be deleted without any errors
	 */
	@Test
	public void testDeleteSession() {
		assertEquals(0, sessionService.getAllSessions().size());

		Course course = null;
		Room room = null;
		Tutor tutor = null;
		Offering offering = null;

		try {
			course = courseService.createCourse("name", Subject.MATH, "ecse321");
			room = roomService.createRoom(123, RoomType.INDIVIDUAL_ROOM);
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			tutor = tutorService.verifyTutor("mail@mail.com");
			offering = offeringService.createOffering(20, 25, course, tutor);
		} catch (IllegalArgumentException e) {
			fail();
		}

		Set<Student> students = new HashSet<Student>();

		sessionService.createSession(2019, 12, 30, 1, 3, 23, 59, room, tutor, offering, students);

		assertEquals(1, sessionService.getAllSessions().size());
		try {
			sessionService.deleteSession(tutor.getEmail(), 1);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, sessionService.getAllSessions().size());
	}
}