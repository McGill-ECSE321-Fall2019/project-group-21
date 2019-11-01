package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.tutoringcompany.model.*;
import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 
 * @author calebsh
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestStudent {

	@InjectMocks
	private TutoringCompanyStudentService StudentService;
	
	@Mock
	private StudentRepository studentRepository;
	
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
    private static final String Email = "student@email.com";
	private static final String phoneNumber = "4500000000";
	private static final String Password = "123456";
	
	@Before
	  public void mockSetUp() {
	    when(studentRepository.save(any(Student.class))).thenAnswer((InvocationOnMock invocation) -> {
	     Student student = new Student();
	     student.setFirst_name(FIRST_NAME);
	     student.setLast_name(LAST_NAME);
	     student.setEmail(Email);
	     student.setPassword(Password);
	     student.setPhone_number(phoneNumber);
	    	return student;
	    });
	    when(studentRepository.findByEmail(anyString())).thenAnswer((InvocationOnMock invocation) -> {
	      
	    	if (invocation.getArgument(0).equals(Email)) {
	        	 Student student = new Student();
	    	     student.setFirst_name(FIRST_NAME);
	    	     student.setLast_name(LAST_NAME);
	    	     student.setEmail(Email);
	    	     student.setPassword(Password);
	    	     student.setPhone_number(phoneNumber);
	    	    	return student;
	    	}
	    	 else {
					return null;
				}
	      });
	 

	  }
	
	/**
	 * Create a student
	 * @result Student will be persisted without any errors
	 */
	@Test
	public void testCreateStudent(){
		try {
			StudentService.createStudent(FIRST_NAME, LAST_NAME, Email, phoneNumber, Password);
		} catch (IllegalArgumentException e) {
			fail();
		}
		 
		Student m =StudentService.getstudent(Email);
		 assertEquals(FIRST_NAME, m.getFirst_name());
		 assertEquals(LAST_NAME, m.getLast_name());
		 assertEquals(Email, m.getEmail());
		 assertEquals(phoneNumber, m.getPhone_number());
		 assertEquals(Password, m.getPassword());
		 
		 
	}
	
	/**
	 * Create a student with a null name
	 * @result Student will not be created due to an error
	 */
	@Test
	public void testCreateStudentNull() {
		
		String firstName = null;
		String error = null;
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your student details are incomplete!", error);
		
	}
	

	
	/**
	 * Create a student with a space as it's first name
	 * @result Student will not be created due to an error
	 */
	@Test
	public void testCreateStudentSpaces() {
		
		String firstName = " ";
		String error = null;
		try {
			StudentService.createStudent(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your student details are incomplete!", error);
		
	}
}