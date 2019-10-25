package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Course;


import org.springframework.data.repository.query.Param;


import org.springframework.web.bind.annotation.CrossOrigin;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	Course findByCourseid(String courseid);
}