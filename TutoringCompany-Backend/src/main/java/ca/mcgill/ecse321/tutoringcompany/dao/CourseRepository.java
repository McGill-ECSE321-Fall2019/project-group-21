//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import ca.mcgill.ecse321.tutoringcompany.model.Person;
//import ca.mcgill.ecse321.tutoringcompany.model.Course;
////
////
////
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin(origins = "*")
//public interface CourseRepository extends CrudRepository<Course, String> {
//
//	 Course findByName(@Param(value = "name") String name);
//	
//		
//
//  Iterable<Course> findAll();
//
// 
//  Course save(Course course);
//}