package ca.mcgill.ecse321.tutoringcompany.service;
import java.security.InvalidParameterException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;

@Service
public class TutoringCompanyTutorReviewsService {
	@Autowired
	TutorReviewsRepository tutorReviewsRepository;
	@Autowired
	private TutoringCompanyTutorService TutorService;
	//create method

	@Transactional
	public TutorReviews createTutorReview(String body, int stars, String email) {
		TutorService.tutorExist(email);
		if(incorrectTutorReviewsDetails(body,stars,email)) {
			throw new InvalidParameterException("Your tutor review details are incomplete!");
		}
		TutorReviews reviews = new TutorReviews();
		reviews.setBody(body);
		reviews.setStars(stars);
		reviews.setTutor(TutorService.getTutor(email));
		tutorReviewsRepository.save(reviews);
		return reviews;
	}
	//get methods
	@Transactional
	public List<TutorReviews> getAllTutorReviews() {
		return (List<TutorReviews>) tutorReviewsRepository.findAll();
	}
	/*
	 * @param id : ID of TutorReview that is trying to be read
	 * @throws NoSuchElementException if review is null.   
	 */
	@Transactional 
	public TutorReviews getTutorReview(int id) {
		TutorReviews review = tutorReviewsRepository.findById(id).get();
		return review;
	}

	@Transactional
	public List<TutorReviews> getAllReviewsForTutor(Tutor tutor) {
		List<TutorReviews> reviews =new ArrayList<TutorReviews>();
		for (TutorReviews review: toList(tutorReviewsRepository.findAll())) {
			if (review.getTutor().equals(tutor)) {
				reviews.add(review);
			}
		}
		return reviews;
	}

	//update methods
	@Transactional
	public void updateBody(TutorReviews review, String body) {
		review.setBody(body);
		tutorReviewsRepository.save(review);
	}

	@Transactional
	public void updateStars(TutorReviews review, int stars) {
		review.setStars(stars);
		tutorReviewsRepository.save(review);
	}

	@Transactional
	public void updateTutorReview(TutorReviews review, String body, int stars) {
		updateStars(review,stars);
		updateBody(review,body);
		tutorReviewsRepository.save(review);
	}
	
	@Transactional
	public void updateTutorReviewsBody(TutorReviews review, String body) {
		review.setBody(body);
	}

	//delete method
	public void deleteTutorReview(TutorReviews review) {
		tutorReviewsRepository.delete(review);
	}


	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

	private boolean incorrectTutorReviewsDetails(String body, int stars, String email) {
		if(body == null || body.trim().length() == 0 || stars > 5 || stars < 0 || email == null || email.trim().length() == 0) {
			return true;
		}
		return false;
	}
}