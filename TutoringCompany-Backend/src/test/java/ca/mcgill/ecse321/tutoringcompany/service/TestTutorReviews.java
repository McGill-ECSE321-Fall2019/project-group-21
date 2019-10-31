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
//import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
//import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorReviewsService;
//
///**
// * 
// * @author calebsh
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestTutorReviews {
//
//	@Autowired
//	private TutoringCompanyTutorReviewsService TutorReviewsService;
//
//	@Autowired
//	private TutorRepository tutorRepository;
//	
//	@Before
//	public void clearDatabase() {
//		tutorRepository.deleteAll();
//	}
//	
//	/**
//	 * Create a tutor review
//	 * @result Tutor review will be persisted without any errors
//	 */
//	@Test
//	public void testCreateTutorReview() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		String body = "body";
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		try {
//			//why does createStudentReview have an int id but not createTutorReview?
//			TutorReviewsService.createTutorReview(body, 5, tutor);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		List<TutorReviews> allTutorReviews = TutorReviewsService.getAllReviewsForTutor(tutor);
//		assertEquals(1, allTutorReviews.size());
//		assertEquals(body, allTutorReviews.get(0).getBody());
//	}
//	
//	//no checks in tutorreviewsservice for improper variables
//	/**
//	 * Create a tutor review with a null name
//	 * @result Tutor review will not be created due to an error
//	 */
//	@Test
//	public void testCreateTutorReviewNull() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		String body = null;
//		String error = null;
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		try {
//			TutorReviewsService.createTutorReview(body, 5, tutor);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		assertEquals("Your tutor review details are incomplete!", error);
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//	}
//	
//	/**
//	 * Create a tutor review with an empty name
//	 * @result Tutor review will not be created due to an error
//	 */
//	@Test
//	public void testCreateTutorReviewEmpty() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		String body = "";
//		String error = null;
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		try {
//			TutorReviewsService.createTutorReview(body, 5, tutor);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		assertEquals("Your tutor review details are incomplete!", error);
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//	}
//	
//	/**
//	 * Create a tutor review with a space as its body
//	 * @result Tutor review will not be created due to an error
//	 */
//	@Test
//	public void testCreateTutorReviewSpaces() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		String body = " ";
//		String error = null;
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		try {
//			TutorReviewsService.createTutorReview(body, 5, tutor);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		assertEquals("Your tutor review details are incomplete!", error);
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//	}
//	
//	/**
//	 * Delete a tutor review
//	 * @result Tutor review will be deleted without any errors
//	 */
//	@Test
//	public void testDeleteTutorReview() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		TutorReviewsService.createTutorReview("body", 5, tutor);
//		assertEquals(1, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		try {
//			//messed up name in tutorreviewsservice
//			//how can you getTutorReview with id when you don't create it with an id?
//			TutorReviewsService.deleteTutorReview(TutorReviewsService.getTutorReview(123));
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//	}
//	
//	/**
//	 * Update a student review
//	 * @result Student review will be updated without any errors
//	 */
//	@Test
//	public void testUpdateTutorReview() {
//		
//		Tutor tutor = new Tutor();
//		//tutor.setFirst_name("fName");
//		//tutor.setLast_name("lName");
//		//tutor.setEmail("mail@mail.com");
//		//tutor.setPhone_number("pNum");
//		//tutor.setPassword("pWord");
//		
//		assertEquals(0, TutorReviewsService.getAllReviewsForTutor(tutor).size());
//		
//		int id = 123;
//		String body1 = "body1";
//		String body2 = "body2";
//		int stars1 = 1;
//		int stars2 = 5;
//		
//		try {
//			TutorReviewsService.createTutorReview(id, body1, stars1, tutor);;
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		
//		TutorReviewsService.updateTutorReview(TutorReviewsService.getTutorReview(id), body2, stars2);
//		
//		List<TutorReviews> allTutorReviews = TutorReviewsService.getAllReviewsForTutor(tutor);
//		TutorReviews tutorReview = allTutorReviews.get(0);
//		
//		assertEquals(body2, tutorReview.getBody());
//		assertEquals(stars2, tutorReview.getStars());
//	}
//	
//}