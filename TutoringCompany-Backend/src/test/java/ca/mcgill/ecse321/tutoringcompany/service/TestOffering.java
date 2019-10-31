//package ca.mcgill.ecse321.tutoringcompany.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
//import ca.mcgill.ecse321.tutoringcompany.model.Course;
//import ca.mcgill.ecse321.tutoringcompany.model.Offering;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//import ca.mcgill.ecse321.tutoringcompany.model.Subject;
//
//
///**
// * 
// * @author George Kandalaft
// * @author Caleb Lim
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestOffering {
//	
//	@Autowired
//	private TutoringCompanyOfferingService OfferingService;
//	
//	@Autowired
//	private OfferingRepository offeringRepository;
//	
//	@Before
//	public void clearDatabase() {		
//		offeringRepository.deleteAll();
//	}
//	
//	/**
//	 * Create an offering
//	 * @result Offering will be persisted without any errors
//	 */
//	@Test
//	public void testCreateOffering(){
//		assertEquals(0, OfferingService.getAllOfferings().size());
//
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		Course course = new Course();
//		//course.setName("name");
//		//course.setCourse_id("id");
//		//course.setSubject(Subject.MATH);
//
//		int individualPrice = 15;
//		
//		try {
//			OfferingService.createOffering(individualPrice, 20, course, tutor);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		List<Offering> allOffering = OfferingService.getAllOfferings();
//		assertEquals(1, allOffering.size());
//		assertEquals(individualPrice, allOffering.get(0).getPrice_individual());
//	}
//	
//	/**
//	 * Create an offering with a null course
//	 * @result Offering will not be created due to an error
//	 */
//	@Test
//	public void testCreateOfferingNull() {
//		assertEquals(0, OfferingService.getAllOfferings().size());
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		Course course = null;
//		
//		String error = null;
//		
//		try {
//			OfferingService.createOffering(15, 20, course, tutor);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//		assertEquals("Your offering details are incomplete!", error);
//		assertEquals(0, OfferingService.getAllOfferings().size());
//	}
//	
//	/**
//	 * Delete an offering
//	 * @result Offering will be deleted without any errors
//	 */
//	@Test
//	public void testDeleteOffering() {
//		assertEquals(0, OfferingService.getAllOfferings().size());
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		Course course = new Course();
//		//course.setName("name");
//		//course.setCourse_id("id");
//		//course.setSubject(Subject.MATH);
//		
//		OfferingService.createOffering(15, 20, course, tutor);
//		
//		assertEquals(1, OfferingService.getAllOfferings().size());
//		try {
//			OfferingService.deleteOffering(tutor, course);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		assertEquals(0, OfferingService.getAllOfferings().size());
//	}
//	
//	/**
//	 * Update an offering
//	 * @result Offering will be updated without any errors
//	 */
//	@Test
//	public void testUpdateOffering() {
//		
//		assertEquals(0, OfferingService.getAllOfferings().size());
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		Course course = new Course();
//		//course.setName("name");
//		//course.setCourse_id("id");
//		//course.setSubject(Subject.MATH);
//		
//		int individualPrice1 = 15;
//		int individualPrice2 = 20;
//		int groupPrice1 = 20;
//		int groupPrice2 = 30;
//		
//		try {
//			OfferingService.createOffering(individualPrice1, groupPrice1, course, tutor);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		
//		OfferingService.updatePrice_individual(OfferingService.getSpecificOffering(tutor, course), individualPrice2);
//		OfferingService.updatePrice_group(OfferingService.getSpecificOffering(tutor, course), groupPrice2);
//		
//		List<Offering> allOfferings = OfferingService.getAllOfferings();
//		Offering offering = allOfferings.get(0);
//		
//		assertEquals(individualPrice2, offering.getPrice_individual());
//		assertEquals(groupPrice2, offering.getPrice_group());
//	}
//
//}
