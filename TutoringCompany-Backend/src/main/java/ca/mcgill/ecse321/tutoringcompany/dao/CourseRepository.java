package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;

public interface CourseRepository extends CrudRepository<Course, String> {
	Optional<Course> findById(String id);
	
	List<Course> findCourseBySubject(Subject subject);
}