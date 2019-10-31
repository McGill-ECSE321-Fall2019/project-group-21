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
//import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentReviewsService;
//
///**
// * 
// * @author calebsh
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestStudentReviews {
//
//	@Autowired
//	private TutoringCompanyStudentReviewsService StudentReviewsService;
//
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Before
//	public void clearDatabase() {
//		studentRepository.deleteAll();
//	}
//	
//	/**
//	 * Create a student review
//	 * @result Student review will be persisted without any errors
//	 */
//	@Test
//	public void testCreateStudentReview() {
//		
//		Student student = new Student();
//		student.setFirst_name("fName");
//		student.setLast_name("lName");
//		student.setEmail("mail@mail.com");
//		student.setPhone_number("pNum");
//		student.setPassword("pWord");
//		
//		String body = "body";
//		
//		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
//		try {
//			StudentReviewsService.createTutorReview(123, body, 5, student);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		List<StudentReviews> allStudentReviews = StudentReviewsService.getAllReviewsForStudent(student);
//		assertEquals(1, allStudentReviews.size());
//		assertEquals(body, allStudentReviews.get(0).getBody());
//	}
//	
////	//no checks in studentreviewsservice for improper variables
////	/**
////	 * Create a student review with a null name
////	 * @result Student review will not be created due to an error
////	 */
////	@Test
////	public void testCreateStudentReviewNull() {
////		
////		Student student = new Student();
////		student.setFirst_name("fName");
////		student.setLast_name("lName");
////		student.setEmail("mail@mail.com");
////		student.setPhone_number("pNum");
////		student.setPassword("pWord");
////		
////		String body = null;
////		String error = null;
////		
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////		try {
////			StudentReviewsService.createStudentReview(123, body, 5, student);
////		} catch (IllegalArgumentException e) {
////			error = e.getMessage();
////		}
////
////		assertEquals("Your student review details are incomplete!", error);
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////	}
//	
////	/**
////	 * Create a student review with an empty name
////	 * @result Student review will not be created due to an error
////	 */
////	@Test
////	public void testCreateStudentReviewEmpty() {
////
////		Student student = new Student();
////		student.setFirst_name("fName");
////		student.setLast_name("lName");
////		student.setEmail("mail@mail.com");
////		student.setPhone_number("pNum");
////		student.setPassword("pWord");
////		
////		String body = "";
////		String error = null;
////		
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////		try {
////			StudentReviewsService.createStudentReview(123, body, 5, student);
////		} catch (IllegalArgumentException e) {
////			error = e.getMessage();
////		}
////
////		assertEquals("Your student review details are incomplete!", error);
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////	}
////	
////	/**
////	 * Create a student review with a space as its body
////	 * @result Student review will not be created due to an error
////	 */
////	@Test
////	public void testCreateStudentReviewSpaces() {
////		Student student = new Student();
////		student.setFirst_name("fName");
////		student.setLast_name("lName");
////		student.setEmail("mail@mail.com");
////		student.setPhone_number("pNum");
////		student.setPassword("pWord");
////		
////		String body = " ";
////		String error = null;
////		
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////		try {
////			StudentReviewsService.createStudentReview(123, body, 5, student);
////		} catch (IllegalArgumentException e) {
////			error = e.getMessage();
////		}
////
////		assertEquals("Your student review details are incomplete!", error);
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////	}
////	
////	/**
////	 * Delete a student review
////	 * @result Student review will be deleted without any errors
////	 */
////	@Test
////	public void testDeleteStudentReview() {
////		
////		Student student = new Student();
////		student.setFirst_name("fName");
////		student.setLast_name("lName");
////		student.setEmail("mail@mail.com");
////		student.setPhone_number("pNum");
////		student.setPassword("pWord");
////		
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////		StudentReviewsService.createStudentReview(123, "body", 5, student);
////		assertEquals(1, StudentReviewsService.getAllReviewsForStudent(student).size());
////		try {
////			//messed up name in studentreviewsservice
////			StudentReviewsService.deleteStudentReview(StudentReviewsService.getStudentReview(123));
////		} catch (IllegalArgumentException e) {
////			fail();
////		}
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////	}
////	
////	/**
////	 * Update a student review
////	 * @result Student review will be updated without any errors
////	 */
////	@Test
////	public void testUpdateStudentReview() {
////		
////		Student student = new Student();
////		student.setFirst_name("fName");
////		student.setLast_name("lName");
////		student.setEmail("mail@mail.com");
////		student.setPhone_number("pNum");
////		student.setPassword("pWord");
////		
////		assertEquals(0, StudentReviewsService.getAllReviewsForStudent(student).size());
////		
////		int id = 123;
////		String body1 = "body1";
////		String body2 = "body2";
////		int stars1 = 1;
////		int stars2 = 5;
////		
////		try {
////			StudentReviewsService.createStudentReview(id, body1, stars1, student);;
////		} catch (IllegalArgumentException e) {
////			fail();
////		}
////		
////		StudentReviewsService.updateStudentReview(StudentReviewsService.getStudentReview(id), body2, stars2);
////		
////		List<StudentReviews> allStudentReviews = StudentReviewsService.getAllReviewsForStudent(student);
////		StudentReviews studentReview = allStudentReviews.get(0);
////		
////		assertEquals(body2, studentReview.getBody());
////		assertEquals(stars2, studentReview.getStars());
////	}
//	
//}