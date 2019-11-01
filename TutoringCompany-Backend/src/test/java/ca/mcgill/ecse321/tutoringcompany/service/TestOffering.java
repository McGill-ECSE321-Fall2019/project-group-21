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

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;


/**
 * 
 * @author George Kandalaft
 * @author Caleb Lim
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOffering {
	
	@Autowired
	private TutoringCompanyOfferingService offeringService;
	
	@Autowired
	private TutoringCompanyCourseService courseService;
	
	@Autowired
	private TutoringCompanyTutorService tutorService;
	
	
	@Autowired
	private TutorTimeBlockRepository tutorTimeBlockRepository;
	
	@Autowired
	private TutorReviewsRepository tutorReviewsRepository;
	
	@Autowired
	private OfferingRepository offeringRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private  TutorRepository tutorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Before
	public void clearDatabase() {
		sessionRepository.deleteAll();
		offeringRepository.deleteAll();
		
		tutorTimeBlockRepository.deleteAll();
		sessionRepository.deleteAll();
		tutorReviewsRepository.deleteAll();
		tutorRepository.deleteAll();
		
		courseRepository.deleteAll();
	}
	
	/**
	 * Create an offering
	 * @result Offering will be persisted without any errors
	 */
	@Test
	public void testCreateOffering(){
		assertEquals(0, offeringService.getAllOfferings().size());
		Tutor tutor = null;
		Course course = null;
		try {
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			course = courseService.createCourse("name", Subject.MATH, "math240");
		} catch (IllegalArgumentException e) {
			fail();
		}


		int individualPrice = 15;
		
		try {
			offeringService.createOffering(individualPrice, 20, course, tutor);
		} catch (IllegalArgumentException e) {
			System.out.println("failed here >>>>>>>>>>>>>>>>>>>>");
			fail();
		}
		List<Offering> allOffering = offeringService.getAllOfferings();
		assertEquals(1, allOffering.size());
		assertEquals(individualPrice, allOffering.get(0).getPrice_individual());
	}
	
	/**
	 * Create an offering with a null course
	 * @result Offering will not be created due to an error
	 */
	@Test
	public void testCreateOfferingNull() {
		assertEquals(0, offeringService.getAllOfferings().size());
		
		Tutor tutor = null;
		Course course = null;
		try {
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		String error = null;
		
		try {
			offeringService.createOffering(15, 20, course, tutor);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your offering details are incomplete!", error);
		assertEquals(0, offeringService.getAllOfferings().size());
	}
	
	/**
	 * Create an offering with a negative individual price
	 * @result Offering will not be created due to an error
	 */
	@Test
	public void testCreateOfferingNegative() {
		assertEquals(0, offeringService.getAllOfferings().size());
		
		Tutor tutor = null;
		Course course = null;
		try {
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			course = courseService.createCourse("name", Subject.MATH, "math240");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		String error = null;
		int price_individual = -25;
		try {
			offeringService.createOffering(price_individual, 20, course, tutor);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your offering details are incomplete!", error);
		assertEquals(0, offeringService.getAllOfferings().size());
	}
	
	/**
	 * Delete an offering
	 * @result Offering will be deleted without any errors
	 */
	@Test
	public void testDeleteOffering() {
		assertEquals(0, offeringService.getAllOfferings().size());
		
		Tutor tutor = null;
		Course course = null;
		try {
			tutor = tutorService.createTutor("Louca", "Dufault", "mail@mail.com", "1234567890", "pWord");
			course = courseService.createCourse("name", Subject.MATH, "math240");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		Offering offering = offeringService.createOffering(15, 20, course, tutor);
		
		assertEquals(1, offeringService.getAllOfferings().size());
		try {
			offeringService.deleteOffering(offering);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, offeringService.getAllOfferings().size());
	}
	
	/**
	 * Update an offering
	 * @result Offering will be updated without any errors
	 */
	@Test
	public void testUpdateOffering() {
		
		assertEquals(0, offeringService.getAllOfferings().size());
		Tutor tutor = null;
		Course course = null;
		try {
			tutor = tutorService.createTutor("Ryan", "Dufault", "mail@mail.com", "1234567890", "pWord");
			course = courseService.createCourse("name", Subject.MATH, "math240");
		} catch (IllegalArgumentException e) {
			fail();
		}

		Offering offering = null;

		
		int individualPrice2 = 20;
		int groupPrice2 = 30;
		
		try {
			offering = offeringService.createOffering(15, 20, course, tutor);
		} catch (IllegalArgumentException e) {
			fail();
		}	
		
		offeringService.updatePrice_individual(offering.getId(), individualPrice2);
		offeringService.updatePrice_group(offering.getId(), groupPrice2);
		
		List<Offering> allOfferings = offeringService.getAllOfferings();
		
		assertEquals(individualPrice2, allOfferings.get(0).getPrice_individual());
		assertEquals(groupPrice2, allOfferings.get(0).getPrice_group());
	}

}