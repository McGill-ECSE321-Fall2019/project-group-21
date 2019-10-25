package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
@Service
public class TutoringCompanyCourseService {
	
	@Autowired
    CourseRepository courseRepository;
	
	//create method
	@Transactional
	public Course createCourse(String name, Subject subject, String Course_id) {
		Course course = new Course();
		course.setCourse_id(Course_id);
		course.setName(name);
		course.setSubject(subject);
		
		courseRepository.save(course);
		return course;
	}
	
	//read methods
	@Transactional
	public Optional<Course> getCourse(String courseid) {
		Optional<Course> course = courseRepository.findById(courseid);
		return course;
	}
	
	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepository.findAll());
	}
	
	
	//update methods
	@Transactional
	public void updateName(String courseid, String newName) {
		getCourse(courseid).get().setName(newName);
	}
	
	@Transactional
	public void updateSubject(String courseid, Subject newSubject) {
		getCourse(courseid).get().setSubject(newSubject);
	}
	
	//update methods combined:
	public void updateCourse(String courseid, String newName, Subject newSubject) {
		updateName(courseid, newName);
		updateSubject(courseid, newSubject);
	}
	//delete method
	@Transactional
	public void deleteCourse(String courseid) {
		courseRepository.deleteById(courseid);
	}
	
	//function for getAllCourses
	private <T> List<T> toList(Iterable<T> iterable){
    	List<T> resultList = new ArrayList<T>();
    	for (T t : iterable) {
    	resultList.add(t);
    	}
    	return resultList;
    	}
}
