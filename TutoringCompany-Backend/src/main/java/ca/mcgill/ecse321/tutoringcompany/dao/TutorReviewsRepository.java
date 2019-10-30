package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;

public interface TutorReviewsRepository extends CrudRepository<TutorReviews, Integer> {
	


}
