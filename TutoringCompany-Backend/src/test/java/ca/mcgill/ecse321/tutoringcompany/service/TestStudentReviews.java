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

import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
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
	private TutoringCompanyStudentReviewsService studentReviewsService;
	private TutoringCompanyStudentService studentService;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentReviewsRepository studentReviewsRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Before
	public void clearDatabase() {
//		sessionRepository.deleteAll();
//		studentRepository.deleteAll();
//		
		studentReviewsRepository.deleteAll(); // was first
	}
	
	/**
	 * Create a student review
	 * @result Student review will be persisted without any errors
	 */
	@Test
	public void testCreateStudentReview() {

		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		String body = "body";
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		
		try {
			studentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		List<StudentReviews> allStudentReviews = studentReviewsService.getAllStudentReviews();
		
		assertEquals(1, allStudentReviews.size());
		assertEquals(body, allStudentReviews.get(0).getBody());
	}
	
	/**
	 * Create a student review with a null name
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewNull() {
		
		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		String body = null;
		String error = null;
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		try {
			studentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Create a student review with an empty name
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewEmpty() {

		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		String body = "";
		String error = null;
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		try {
			studentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Create a student review with a space as its body
	 * @result Student review will not be created due to an error
	 */
	@Test
	public void testCreateStudentReviewSpaces() {
		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		String body = " ";
		String error = null;
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		try {
			studentReviewsService.createStudentReview(body, 5, "mail@mail.com");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals("Your student review details are incomplete!", error);
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Delete a student review
	 * @result Student review will be deleted without any errors
	 */
	@Test
	public void testDeleteStudentReview() {

		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		StudentReviews studentReview = studentReviewsService.createStudentReview("body", 5, "mail@mail.com");
		assertEquals(1, studentReviewsService.getAllStudentReviews().size());
		
		try {
			studentReviewsService.deleteStudentReview(studentReviewsService.getAllStudentReviews().get(0));
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
	}
	
	/**
	 * Update a student review
	 * @result Student review will be updated without any errors
	 */
	@Test
	public void testUpdateStudentReview() {
		
		studentService.createStudent("fName","lName","mail@mail.com","1234567890","pWord");
		
		assertEquals(0, studentReviewsService.getAllStudentReviews().size());
		
		String body1 = "body1";
		String body2 = "body2";
		int stars1 = 1;
		int stars2 = 5;
		
		StudentReviews studentReview = studentReviewsService.createStudentReview(body1, stars1, "mail@mail.com");
		
		
		studentReviewsService.updateStudentReview(studentReview, body2, stars2);
		
		List<StudentReviews> allStudentReviews = studentReviewsService.getAllStudentReviews();
		StudentReviews studentRevieww = allStudentReviews.get(0);
		
		assertEquals(body2, studentRevieww.getBody());
		assertEquals(stars2, studentRevieww.getStars());
	}
	
}