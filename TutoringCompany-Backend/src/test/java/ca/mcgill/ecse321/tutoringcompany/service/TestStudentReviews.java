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

import ca.mcgill.ecse321.tutoringcompany.dao.StudentReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentReviewsService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudentReviews {

	@Autowired
	private TutoringCompanyStudentReviewsService StudentReviewsService;

	@Autowired
	private StudentReviewsRepository studentReviewsRepository;
	
//	@Before
//	public void clearDatabase() {
//		studentReviewsRepository.deleteAll();
//	}
	
	/**
	 * Create a student review
	 * @result Student review will be persisted without any errors
	 */
	@Test
	public void testCreateStudentReview() {
		
		String body = "body";
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		try {
			StudentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<StudentReviews> allStudentReviews = StudentReviewsService.getAllStudentReviews();
		assertEquals(1, allStudentReviews.size());
		assertEquals(body, allStudentReviews.get(0).getBody());
	}
	
	/**
	 * Create a student review with a null name
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewNull() {
		
		String body = null;
		String error = null;
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		try {
			StudentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Create a student review with an empty name
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewEmpty() {

		String body = "";
		String error = null;
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		try {
			StudentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Create a student review with a space as its body
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewSpaces() {
		
		String body = " ";
		String error = null;
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		try {
			StudentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Delete a student review
	 * @result Student review will be deleted without any errors
	 */
	@Test
	public void testDeleteStudentReview() {
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		StudentReviewsService.createStudentReview("body", 5, "mail@mail.com");
		assertEquals(1, StudentReviewsService.getAllStudentReviews().size());
		try {
			StudentReviewsService.deleteStudentReview(StudentReviewsService.getStudentReview(123));
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Update a student review
	 * @result Student review will be updated without any errors
	 */
	@Test
	public void testUpdateStudentReview() {
		
		assertEquals(0, StudentReviewsService.getAllStudentReviews().size());
		
		String body1 = "body1";
		String body2 = "body2";
		int stars1 = 1;
		int stars2 = 5;
		
		StudentReviews studentReview = StudentReviewsService.createStudentReview(body1, stars1, "mail@mail.com");
		
		
		StudentReviewsService.updateStudentReview(studentReview, body2, stars2);
		
		List<StudentReviews> allStudentReviews = StudentReviewsService.getAllStudentReviews();
		StudentReviews studentRevieww = allStudentReviews.get(0);
		
		assertEquals(body2, studentRevieww.getBody());
		assertEquals(stars2, studentRevieww.getStars());
	}
	
}