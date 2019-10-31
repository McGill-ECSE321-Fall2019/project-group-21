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

import ca.mcgill.ecse321.tutoringcompany.dao.TutorReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorReviewsService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTutorReviews {

	@Autowired
	private TutoringCompanyTutorReviewsService TutorReviewsService;

	@Autowired
	private TutorReviewsRepository tutorReviewsRepository;
	
//	@Before
//	public void clearDatabase() {
//		tutorReviewsRepository.deleteAll();
//	}
	
	/**
	 * Create a tutor review
	 * @result Tutor review will be persisted without any errors
	 */
	@Test
	public void testCreateTutorReview() {
		
		String body = "body";
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		try {
			TutorReviewsService.createTutorReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<TutorReviews> allTutorReviews = TutorReviewsService.getAllTutorReviews();
		assertEquals(1, allTutorReviews.size());
		assertEquals(body, allTutorReviews.get(0).getBody());
	}
	
	/**
	 * Create a tutor review with a null name
	 * @result Tutor review will not be created due to an error
	 */
	@Test
	public void testCreateTutorReviewNull() {
		
		String body = null;
		String error = null;
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		try {
			TutorReviewsService.createTutorReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your tutor review details are incomplete!", error);
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
	}
	
	/**
	 * Create a tutor review with an empty name
	 * @result Tutor review will not be created due to an error
	 */
	@Test
	public void testCreateTutorReviewEmpty() {
		
		String body = "";
		String error = null;
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		try {
			TutorReviewsService.createTutorReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your tutor review details are incomplete!", error);
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
	}
	
	/**
	 * Create a tutor review with a space as its body
	 * @result Tutor review will not be created due to an error
	 */
	@Test
	public void testCreateTutorReviewSpaces() {
		
		String body = " ";
		String error = null;
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		try {
			TutorReviewsService.createTutorReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your tutor review details are incomplete!", error);
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
	}
	
	/**
	 * Delete a tutor review
	 * @result Tutor review will be deleted without any errors
	 */
	@Test
	public void testDeleteTutorReview() {
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		TutorReviews tutorreview = TutorReviewsService.createTutorReview("body", 5, "mail@mail.com");
		assertEquals(1, TutorReviewsService.getAllTutorReviews().size());
		try {
			TutorReviewsService.deleteTutorReview(tutorreview);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
	}
	
	/**
	 * Update a student review
	 * @result Student review will be updated without any errors
	 */
	@Test
	public void testUpdateTutorReview() {
		
		assertEquals(0, TutorReviewsService.getAllTutorReviews().size());
		
		String body1 = "body1";
		String body2 = "body2";
		int stars1 = 1;
		int stars2 = 5;
		
		TutorReviews tutorreview = TutorReviewsService.createTutorReview(body1, stars1, "mail@mail.com");
		
		TutorReviewsService.updateTutorReview(tutorreview, body2, stars2);
		
		List<TutorReviews> allTutorReviews = TutorReviewsService.getAllTutorReviews();
		TutorReviews tutorrevieww = allTutorReviews.get(0);
		
		assertEquals(body2, tutorrevieww.getBody());
		assertEquals(stars2, tutorrevieww.getStars());
	}
	
}