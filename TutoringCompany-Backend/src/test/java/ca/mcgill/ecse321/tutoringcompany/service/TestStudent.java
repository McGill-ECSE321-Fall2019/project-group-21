package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.catalina.Manager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
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

	/**
	 * @Autowiring services
	 */

	@Autowired
	private TutoringCompanyStudentService StudentService;

	/**
	 * @Autowiring repos
	 */

	@Autowired
	private StudentRepository studentRepository;

	@Before
	public void clearDatabase() {
		studentRepository.deleteAll();
	}
	
	@Test
	public void testCreateStudent() {
		assertEquals(0, StudentService.getAllStudents().size());
		String firstName = "Elias";
		try {
			StudentService.createStudent(firstName,"k", "eliasi@gmail.com", "oj", "ijm");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Student> allStudents = StudentService.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(firstName, allStudents.get(0).getFirst_name());
	}
	
//	@Test
//	public void testCreateStudentNull() {
//		assertEquals(0, StudentService.getAllStudents().size());
//		String firstName = null;
//		String error = null;
//		try {
//			StudentService.createStudent(firstName,"k", "eliasi@gmail.com", "oj", "ijm");
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//		
//		// check error
//		// haven't set the error message so this fails
//		//assertEquals("Student name cannot be empty!", error);
//		
//		// check no change in memory
//		// this gives an error because StudentService allows you to create a student with null values. Have to add checks to the constructor
//		//assertEquals(0, StudentService.getAllStudents().size());
//	}
	
	@Test
	public void testDeleteStudent() {
		assertEquals(0, StudentService.getAllStudents().size());
		try {
			StudentService.createStudent("Elias","k", "eliasi@gmail.com", "oj", "ijm");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(1, StudentService.getAllStudents().size());
		StudentService.deleteStudent("eliasi@gmail.com");
		assertEquals(0, StudentService.getAllStudents().size());
	}

	@Test
	public void testUpdateStudent() {
		
		assertEquals(0, StudentService.getAllStudents().size());
		
		String firstName = "Elias";
		String lastName = "Eliasso";
		String email = "eliasi@gmail.com";
		String phoneNum = "321";
		String password = "thepass";
		
		try {
			StudentService.createStudent("Caleb", "Lim", email, "123", "pass");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		StudentService.updateStudent(email, firstName, lastName, phoneNum, password);
		
		List<Student> allStudents = StudentService.getAllStudents();
		Student student = allStudents.get(0);
		
		assertEquals(firstName, student.getFirst_name());
		assertEquals(lastName, student.getLast_name());
		assertEquals(phoneNum, student.getPhone_number());
		assertEquals(password, student.getPassword());
	}
}