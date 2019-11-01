package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {

	@Autowired
	private TutoringCompanyStudentService StudentService;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Before
	public void clearDatabase() {
		sessionRepository.deleteAll();
		studentRepository.deleteAll();
	}
	
//@Test
//public void test() {
//	try {
//		courseRepository.deleteAll();
//	} catch (IllegalArgumentException e) {
//		fail();
//	}
//}
	
	/**
	 * Create a student
	 * @result Student will be persisted without any errors
	 */
	@Test
	public void testCreateStudent() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = "fName";
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Student> allStudents = StudentService.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(firstName, allStudents.get(0).getFirst_name());
	}
	
	/**
	 * Create a student with a null name
	 * @result Student will not be created due to an error
	 */
	@Test
	public void testCreateStudentNull() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = null;
		String error = null;
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your student details are incomplete!", error);
		assertEquals(0, StudentService.getAllStudents().size());
	}
	
	/**
	 * Create a student with an empty name
	 * @result Student will not be created due to an error
	 */
	@Test
	public void testCreateStudentEmpty() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = "";
		String error = null;
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your student details are incomplete!", error);
		assertEquals(0, StudentService.getAllStudents().size());
	}
	
	/**
	 * Create a student with a space as it's first name
	 * @result Student will not be created due to an error
	 */
	@Test
	public void testCreateStudentSpaces() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = " ";
		String error = null;
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your student details are incomplete!", error);
		assertEquals(0, StudentService.getAllStudents().size());
	}
	
	/**
	 * Delete a student
	 * @result Student will be deleted without any errors
	 */
	@Test
	public void testDeleteStudent() {
		assertEquals(0, StudentService.getAllStudents().size());
		testCreateStudent();
		assertEquals(1, StudentService.getAllStudents().size());
		try {
			StudentService.deleteStudent("mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, StudentService.getAllStudents().size());
	}

	/**
	 * Update a student
	 * @result Student will be updated without any errors
	 */
	@Test
	public void testUpdateStudent() {
		
		assertEquals(0, StudentService.getAllStudents().size());
		
		String firstName1 = "fName1";
		String firstName2 = "fName2";
		String lastName1 = "lName1";
		String lastName2 = "lName2";
		String email = "mail@mail.com";
		String phoneNum1 = "pNum1";
		String phoneNum2 = "pNum2";
		String password1 = "pWord1";
		String password2 = "pWord2";
		
		try {
			StudentService.createStudent(firstName1, lastName1, email, phoneNum1, password1);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		StudentService.updateStudent(email, firstName2, lastName2, phoneNum2, password2);
		
		List<Student> allStudents = StudentService.getAllStudents();
		Student student = allStudents.get(0);
		
		assertEquals(firstName2, student.getFirst_name());
		assertEquals(lastName2, student.getLast_name());
		assertEquals(phoneNum2, student.getPhone_number());
		assertEquals(password2, student.getPassword());
	}
}