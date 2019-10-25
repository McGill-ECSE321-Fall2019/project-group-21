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

import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

import ca.mcgill.ecse321.tutoringcompany.model.Course;


/**
 * 
 * @author George Kandalaft
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOffering {
	/**
	 * @Autowiring services
	 */
	
	@Autowired
	private TutoringCompanyOfferingService OfferingService;
	
	@Autowired
	private OfferingRepository offeringRepository;
	
	@Before
	public void clearDatabase() {		
		offeringRepository.deleteAll();
	}
	
	@Test
	public void testCreateOffering(){

		int individualPrice = 15;
		Tutor tutor = new Tutor();
		tutor.setEmail("George.kandalaft@gmail");
		tutor.setFirst_name("George");
		tutor.setLast_name("Kandlaft");
		tutor.setPassword("george");
		tutor.setPhone_number("5146993256");
		
		Course course = new Course();
		course.setName("Math");
		
		try {
			OfferingService.createOffering(individualPrice, 20, course, tutor);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<ca.mcgill.ecse321.tutoringcompany.model.Offering> allOffering = OfferingService.getAllOfferings();
		assertEquals(1, allOffering.size());
		assertEquals(individualPrice, allOffering.get(0).getPrice_individual());
	}

}
