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
import ca.mcgill.ecse321.tutoringcompany.dao.StudentReviewsRepository;
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
	private SessionRepository sessionRepository;
	
	@Autowired
	private StudentReviewsRepository studentReviewsRepository;
	
	@Before
	public void clearDatabase() {
		studentReviewsRepository.deleteAll();
		sessionRepository.deleteAll();
		studentRepository.deleteAll();
	}
	
	/**
	 * Create a student
	 * @result Student will be persisted without any errors
	 */
	@Test
	public void testCreateStudent() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = "fName";
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "1234567890", "pWord");
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
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "1234567890", "pWord");
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
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "1234567890", "pWord");
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
			StudentService.createStudent(firstName, "lName", "mail@mail.com", "1234567890", "pWord");
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
		
		String firstName2 = "fName2";
		String lastName2 = "lName2";
		String email = "mail@mail.com";
		String phoneNum2 = "pNum2";
		String password2 = "pWord2";
		
		try {
			StudentService.createStudent("Name1", "lName1", email, "1234567890", "pWord");
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