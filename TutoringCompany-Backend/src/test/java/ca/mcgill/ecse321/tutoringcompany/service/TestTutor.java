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

	/**
	 * @Autowiring services
	 */

	@Autowired
	private TutoringCompanyTutorService TutorService;

	/**
	 * @Autowiring repos
	 */

	@Autowired
	private TutorRepository tutorRepository;

	@Before
	public void clearDatabase() {
		tutorRepository.deleteAll();
	}

	@Test
	public void testCreateTutor() {
		assertEquals(0, TutorService.getAllTutors().size());
		String firstName = "John";
		try {
			TutorService.createTutor(firstName, "Smith", "john@gmail.com", "450878", "123");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Tutor> allTutors = TutorService.getAllTutors();
		assertEquals(1, allTutors.size());
		assertEquals(firstName, allTutors.get(0).getFirst_name());
	}

	@Test
	public void testDeleteTutor() {
		assertEquals(0, TutorService.getAllTutors().size());
		try {
			TutorService.createTutor("Elias","k", "eliasi@gmail.com", "oj", "ijm");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(1, TutorService.getAllTutors().size());
		TutorService.deleteTutor("eliasi@gmail.com");
		assertEquals(0, TutorService.getAllTutors().size());
	}

	@Test
	public void testUpdateTutor() {

		assertEquals(0, TutorService.getAllTutors().size());

		String firstName = "Elias";
		String lastName = "Eliasso";
		String email = "eliasi@gmail.com";
		String phoneNum = "321";
		String password = "thepass";

		try {
			TutorService.createTutor("Caleb", "Lim", email, "123", "pass");
		} catch (IllegalArgumentException e) {
			fail();
		}

		TutorService.updateTutor(email, firstName, lastName, phoneNum, password);

		List<Tutor> allTutors = TutorService.getAllTutors();
		Tutor tutor = allTutors.get(0);

		assertEquals(firstName, tutor.getFirst_name());
		assertEquals(lastName, tutor.getLast_name());
		assertEquals(phoneNum, tutor.getPhone_number());
		assertEquals(password, tutor.getPassword());
	}

}