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

import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTutor {

	@Autowired
	private TutoringCompanyTutorService TutorService;

	@Autowired
	private TutorRepository tutorRepository;

	@Before
	public void clearDatabase() {
		tutorRepository.deleteAll();
	}

	/**
	 * Create a tutor
	 * @result Tutor will be persisted without any errors
	 */
	@Test
	public void testCreateTutor() {
		assertEquals(0, TutorService.getAllTutors().size());
		String firstName = "fName";
		try {
			TutorService.createTutor(firstName, "lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Tutor> allTutors = TutorService.getAllTutors();
		assertEquals(1, allTutors.size());
		assertEquals(firstName, allTutors.get(0).getFirst_name());
	}
	
	/**
	 * Create a tutor with a null name
	 * @result Tutor will not be created due to an error
	 */
	@Test
	public void testCreateTutorNull() {
		assertEquals(0, TutorService.getAllTutors().size());
		String firstName = null;
		String error = null;
		try {
			TutorService.createTutor(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your tutor details are incomplete!", error);
		assertEquals(0, TutorService.getAllTutors().size());
	}
	
	/**
	 * Create a tutor with an empty name
	 * @result Tutor will not be created due to an error
	 */
	@Test
	public void testCreateTutorEmpty() {
		assertEquals(0, TutorService.getAllTutors().size());
		String firstName = "";
		String error = null;
		try {
			TutorService.createTutor(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your tutor details are incomplete!", error);
		assertEquals(0, TutorService.getAllTutors().size());
	}
	
	/**
	 * Create a tutor with a space as it's first name
	 * @result Tutor will not be created due to an error
	 */
	@Test
	public void testCreateTutorSpaces() {
		assertEquals(0, TutorService.getAllTutors().size());
		String firstName = " ";
		String error = null;
		try {
			TutorService.createTutor(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your tutor details are incomplete!", error);
		assertEquals(0, TutorService.getAllTutors().size());
	}

	/**
	 * Delete a tutor
	 * @result Tutor will be deleted without any errors
	 */
	@Test
	public void testDeleteTutor() {
		assertEquals(0, TutorService.getAllTutors().size());
		testCreateTutor();
		assertEquals(1, TutorService.getAllTutors().size());
		try {
			TutorService.deleteTutor("mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, TutorService.getAllTutors().size());
	}

	/**
	 * Update a tutor
	 * @result Tutor will be updated without any errors
	 */
	@Test
	public void testUpdateTutor() {

		assertEquals(0, TutorService.getAllTutors().size());

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
			TutorService.createTutor(firstName1, lastName1, email, phoneNum1, password1);
		} catch (IllegalArgumentException e) {
			fail();
		}

		TutorService.updateTutor(email, firstName2, lastName2, phoneNum2, password2);

		List<Tutor> allTutors = TutorService.getAllTutors();
		Tutor tutor = allTutors.get(0);

		assertEquals(firstName2, tutor.getFirst_name());
		assertEquals(lastName2, tutor.getLast_name());
		assertEquals(phoneNum2, tutor.getPhone_number());
		assertEquals(password2, tutor.getPassword());
	}

}