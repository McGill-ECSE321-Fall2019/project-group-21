package ca.mcgill.ecse321.tutoringcompany.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

/**
 * 
 * @author George Kandalaft
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSession {
	/**
	 * @Autowiring services
	 */
	
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private OfferingRepository offeringRepository;
	
	@Autowired
	private TutoringCompanyTutorService TutorService;
	@Autowired
	private TutoringCompanyStudentService StudentService;
	@Autowired
	private TutoringCompanyCourseService CourseService;	
	@Autowired
	private TutoringCompanySessionService SessionService;
	@Autowired
	private TutoringCompanyOfferingService OfferingService;
	
	@Test
	public void testCreateSession() {
		

		Tutor tutor = TutorService.getTutor("Tutorgeorge@gmail.com");

		Student studentc = StudentService.getstudent("StudentELias@gmail.com");
		
		Student studentf = StudentService.getstudent("StudentGeorge@gmail.com");
		
//		Student fd = StudentService.getstudent("StudentGeorge@gmail.com");
		

		
		Room room = new Room();
		Course course = new Course();
		course.setCourse_id("ECSE321George");
		courseRepository.save(course);
		
		room.setNumber(1);
		roomRepository.save(room);
		
		Offering offering = new Offering();
		offering.setCourse(course);
		offering.setTutor(tutor);
		offeringRepository.save(offering);
		
		
		SessionService.createSession(2020,10,13,14,00,15,00,room,tutor,offering,studentc,studentf);
	}
}
