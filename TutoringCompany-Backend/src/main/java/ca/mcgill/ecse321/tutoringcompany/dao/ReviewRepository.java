//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import ca.mcgill.ecse321.tutoringcompany.model.Person;
//import ca.mcgill.ecse321.tutoringcompany.model.Review;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin(origins = "*")
//public interface ReviewRepository extends CrudRepository<Review, String> {
//
//	 Review findByEmail(@Param(value = "email") String email);
//	
//		
//
//  Iterable<Review> findAll();
//
// 
//  Review save(Review review);
//}