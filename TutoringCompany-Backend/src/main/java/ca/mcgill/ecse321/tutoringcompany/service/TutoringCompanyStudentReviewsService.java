package ca.mcgill.ecse321.tutoringcompany.service;
import java.security.InvalidParameterException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;


@Service
public class TutoringCompanyStudentReviewsService {
	@Autowired
	StudentReviewsRepository studentReviewsRepository;
	@Autowired
	private TutoringCompanyStudentService StudentService;
	//create method

	@Transactional
	public StudentReviews createStudentReview(String body, int stars, String email) {
		StudentService.studentNotExisted(email);
		if(incorrectStudentReviewsDetails(body,stars,email)) {
			throw new InvalidParameterException("Your student review details are incomplete!");
		}
		StudentReviews reviews = new StudentReviews();
		reviews.setBody(body);
		reviews.setStars(stars);
		reviews.setStudent(StudentService.getstudent(email));
		studentReviewsRepository.save(reviews);
		return reviews;
	}
	//get methods
	@Transactional
	public List<StudentReviews> getAllStudentReviews() {
		return (List<StudentReviews>) studentReviewsRepository.findAll();
	}
	/*
	 * @param id : ID of StudentReview that is trying to be read
	 * @throws NoSuchElementException if review is null.   
	 */
	@Transactional 
	public StudentReviews getStudentReview(int id) {
		StudentReviews review = studentReviewsRepository.findById(id).get();
		return review;
	}

	@Transactional
	public List<StudentReviews> getAllReviewsForStudent(Student student) {
		List<StudentReviews> reviews =new ArrayList<StudentReviews>();
		for (StudentReviews review: toList(studentReviewsRepository.findAll())) {
			if (review.getStudent().equals(student)) {
				reviews.add(review);
			}
		}
		return reviews;
	}

	//update methods
	@Transactional
	public void updateStudentReviewsBody(StudentReviews review, String body) {
		review.setBody(body);
	}

	@Transactional
	public void updateStudentReviewsStars(StudentReviews review, int stars) {
		review.setStars(stars);
	}

	@Transactional
	public void updateStudentReview(StudentReviews review, String body, int stars) {
		updateStudentReviewsStars(review,stars);
		updateStudentReviewsBody(review,body);
	}

	//delete method
	public void deleteStudentReview(StudentReviews review) {
		studentReviewsRepository.delete(review);
	}


	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

	private boolean incorrectStudentReviewsDetails(String body, int stars, String email) {
		if(body == null || body.trim().length() == 0 || stars > 5 || stars < 0 || email == null || email.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
