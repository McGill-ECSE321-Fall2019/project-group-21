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
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
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
public class TestTutor {

	@InjectMocks
	private TutoringCompanyTutorService TutorService;
	
	@Mock
	private TutorRepository tutorRepository;
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
    private static final String Email = "tutor@email.com";
	private static final String phoneNumber = "4500000000";
	private static final String Password = "123456";
	
	@Before
	  public void mockSetUp() {
	    when(tutorRepository.save(any(Tutor.class))).thenAnswer((InvocationOnMock invocation) -> {
	     Tutor tutor = new Tutor();
	     tutor.setFirst_name(FIRST_NAME);
	     tutor.setLast_name(LAST_NAME);
	     tutor.setEmail(Email);
	     tutor.setPassword(Password);
	     tutor.setPhone_number(phoneNumber);
	    	return tutor;
	    });
	    when(tutorRepository.findByEmail(anyString())).thenAnswer((InvocationOnMock invocation) -> {
	      
	    	if (invocation.getArgument(0).equals(Email)) {
	        	 Tutor tutor = new Tutor();
	    	     tutor.setFirst_name(FIRST_NAME);
	    	     tutor.setLast_name(LAST_NAME);
	    	     tutor.setEmail(Email);
	    	     tutor.setPassword(Password);
	    	     tutor.setPhone_number(phoneNumber);
	    	    	return tutor;
	    	}
	    	 else {
					return null;
				}
	      });
	 

	  }
	
	/**
	 * Create a tutor
	 * @result Tutor will be persisted without any errors
	 */
	@Test
	public void testCreateTutor(){
		try {
			TutorService.createTutor(FIRST_NAME, LAST_NAME, Email, phoneNumber, Password);
		} catch (IllegalArgumentException e) {
			fail();
		}
		 
		Tutor m =TutorService.getTutor(Email);
		 assertEquals(FIRST_NAME, m.getFirst_name());
		 assertEquals(LAST_NAME, m.getLast_name());
		 assertEquals(Email, m.getEmail());
		 assertEquals(phoneNumber, m.getPhone_number());
		 assertEquals(Password, m.getPassword());
		 
		 
	}
	
	/**
	 * Create a tutor with a null name
	 * @result Tutor will not be created due to an error
	 */
	@Test
	public void testCreateTutorNull() {
		
		String firstName = null;
		String error = null;
		try {
			TutorService.createTutor(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your tutor details are incomplete!", error);
		
	}
	

	
	/**
	 * Create a tutor with a space as it's first name
	 * @result Tutor will not be created due to an error
	 */
	@Test
	public void testCreateTutorSpaces() {
		
		String firstName = " ";
		String error = null;
		try {
			TutorService.createTutor(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your tutor details are incomplete!", error);
		
	}
}