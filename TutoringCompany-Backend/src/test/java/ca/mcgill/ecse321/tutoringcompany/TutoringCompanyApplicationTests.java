package ca.mcgill.ecse321.tutoringcompany;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
//import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.*;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Student;

import ca.mcgill.ecse321.tutoringcompany.model.Subject;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;

import ca.mcgill.ecse321.tutoringcompany.model.*;

import ca.mcgill.ecse321.tutoringcompany.service.*;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyOfferingService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;
/**
 * 
 * @author Elias Tamraz
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TutoringCompanyApplicationTests {
/**
 * @Autowiring services
 */
	@Autowired
	private TutoringCompanyTutorService TutorService;
	@Autowired
	private TutoringCompanyStudentService StudentService;
//	@Autowired
//	private TutoringCompanyManagerService ManagerService;
//	@Autowired
//	private TutoringCompanyRoomService RoomService;
	@Autowired
	private TutoringCompanyCourseService CourseService;
	
	@Autowired
	private TutoringCompanySessionService SessionService;
	@Autowired
	private TutoringCompanyOfferingService OfferingService;

/**
 * @Autowiring repos
 */
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private OfferingRepository offeringRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private TutorReviewsRepository tutorReviewsRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private TutoringCompanyTutorReviewsService TutorReviewsService;
	
//	@Autowired
//	private ManagerRepository managerRepository;
//	@Autowired
//	private RoomRepository roomRepository;
	
//@After
//	public void clearDatabase() {
//		// Fisrt, we clear registrations to avoid exceptions due to inconsistencies
//		studentRepository.deleteAll();
//		
//		}
//	@Test
//	public void testCreateStudent() {
//	studentRepository.deleteAll();
//	assertEquals(0, StudentService.getAllStudents().size());
//	String name = "elias";
//	try {
//		StudentService.createStudent(name,"k", "eliasi@gmail.com", "oj", "ijm");
//	} catch (IllegalArgumentException e) {
//	// Check that no error occurred
//	fail();
//	}
//	List<Student> allStudents = StudentService.getAllStudents();
//	assertEquals(1, allStudents.size());
//  assertEquals(name, allStudents.get(0).getFirst_name());
//	}
	
//@Test
//public void testDeleteStudent() {
//StudentService.deleteStudent("samra@gmail.com");
//}

//	@Test
//	public void updateStudent() {
//		StudentService.updateStudent("eliasi@gmail.com", "eliasso", "samo", "450", "thepass");
//	}
//	
//	@Test
//	public void testCreateTutor() {
//		TutorService.createTutor("John", "smith", "john@gmail.com", "450878", "123");
//	}
//	
//
//	@Test
//	public void testCreatTutor(){
//		TutorService.createTutor("george", "kandalaft", "george@gmail.com", "4389883384", "123456");
//	}
//	@Test
//	public void testCreatStudent(){
//		StudentService.createStudent("george", "kandalaft", "ELias@gmail.com", "4389883384", "123456");
//	}
//	
//@Test
//public void testCreatRoom() {
//	RoomService.createRoom(156, RoomType.INDIVIDUAL_ROOM);
//}
	
//@Test
//public void ClearDataBase() {
//	
////	tutorRepository.deleteAll();
////	studentRepository.deleteAll();
////	roomRepository.deleteAll();
////	courseRepository.deleteAll();
////	offeringRepository.deleteAll();
//	sessionRepository.deleteAll();
//	
////	TutorService.createTutor("george", "kandalaft", "Tutorgeorge@gmail.com", "4389883384", "123456");
//	StudentService.createStudent("george", "kandalaft", "StudentELias@gmail.com", "4389883384", "123456");
//	StudentService.createStudent("Student2", "kandalaft", "StudentGeorge@gmail.com", "4389883384", "123456");
//
//}
	
@Test
public void testCreateSession() {
	

	Tutor tutor = TutorService.getTutor("Tutorgeorge@gmail.com");
	tutor.setVerified(true);
	
	Student studentc = StudentService.getstudent("StudentELias@gmail.com");
	
	Student studentf = StudentService.getstudent("StudentGeorge@gmail.com");
	
//	Student fd = StudentService.getstudent("StudentGeorge@gmail.com");
	

	
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

//	public RoomType roomType;
//	@Test
//	public void testCreatRoom() {
//		RoomService. (RoomType.INDIVIDUAL_ROOM);
	
//	}
//	@Test 
//	public void lk() {
//		CourseService.createCourse("kokk", Subject.MATH, "fff");
//	}
}
