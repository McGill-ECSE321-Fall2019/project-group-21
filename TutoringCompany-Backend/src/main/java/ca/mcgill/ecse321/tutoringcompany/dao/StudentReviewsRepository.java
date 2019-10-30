package ca.mcgill.ecse321.tutoringcompany.dao;
import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
public interface StudentReviewsRepository extends CrudRepository<StudentReviews, Integer> { 
}
