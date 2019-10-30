package ca.mcgill.ecse321.tutoringcompany.service;
import java.security.InvalidParameterException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorReviewsRepository;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Student;

@Service
public class TutoringCompanyTutorReviewsService {
   @Autowired
   TutorReviewsRepository tutorReviewsRepository;
	@Autowired
	private TutoringCompanyTutorService TutorService;
   //create method
   
   @Transactional
   public TutorReviews createTutorReview(String body, int stars, String email) {
       TutorReviews reviews = new TutorReviews();
       reviews.setBody(body);
       reviews.setStars(stars);
       reviews.setTutor(TutorService.getTutor(email));
       
       
       tutorReviewsRepository.save(reviews);
       return reviews;
   }
   @Transactional
 public List<TutorReviews> getAllTutorReviews() {
     return (List<TutorReviews>) tutorReviewsRepository.findAll();
 }
  
}