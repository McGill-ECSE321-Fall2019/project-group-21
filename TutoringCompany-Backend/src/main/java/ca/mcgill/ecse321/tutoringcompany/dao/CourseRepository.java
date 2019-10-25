package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	Course findByName(String name);
}