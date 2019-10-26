package ca.mcgill.ecse321.tutoringcompany.service;

/**
 * 
 * @author George Kandalaft
 * @author Louca Dufault
 *
 */

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
@Service
public class TutoringCompanyCourseService {
	
	@Autowired
    CourseRepository courseRepository;
	
	/**
	 * Create Course instance and return it
	 *
	 * @param name
	 * @param subject
	 * @param course_id
	 *  
	 * @return the created course
	 */
	@Transactional
	public Course createCourse(String name, Subject subject, String course_id) {
		Course course = new Course();
		course.setCourse_id(course_id);
		course.setName(name);
		course.setSubject(subject);
		
		courseRepository.save(course);
		return course;
	}
	
	/**
	 * Read a specific course by its id
	 * 
	 * @param course_id
	 * 
	 * @exception NullPointerException if course by that course_id does not exist
	 * 
	 * @return course
	 */
	@Transactional
	public Course getCourse(String course_id) {
		try {
			Course course = courseRepository.findById(course_id).get();
			return course;
		} catch (NoSuchElementException e) {
			throw new NullPointerException("No such Course.");
		}
	}
	
	/**
	 * Read a specific course with a given name and a given subject
	 * 
	 * @param name
	 * @param subject
	 * 
	 * @exception NullPointerException if course with that name and that subject does not exist
	 * 
	 * @return offering
	 */
	@Transactional
	public Course getCourse(String name, Subject subject) {
		for (Course course : getAllCourses()) {
			if (course.getName().equals(name) && course.getSubject().equals(subject)) {
				return course;
			}
		}
		throw new NullPointerException("No such Course.");
	}
	
	/**
	 * Read List of Course with the given subject
	 * 
	 * @param subject
	 * @return List of Courses with the given subject
	 */
	@Transactional
	public List<Course> getCourses(Subject subject) {
		List<Course> coursesBySubject = new ArrayList<>();
		for (Course course : courseRepository.findCourseBySubject()) {
			coursesBySubject.add(course);			
		}
		return coursesBySubject;
	}
	
	/**
	 * Read List of all Courses in the system
	 *
	 * @return List of Courses representing all Courses in the system
	 */
	@Transactional
	public List<Course> getAllCourses() {
		return (List<Course>) courseRepository.findAll();
		//return toList(courseRepository.findAll());
	}
	
	
	/**
	 * Update name for the specific course passed
	 * 
	 * @param course
	 * @param name
	 */
	@Transactional
	public void updateName(Course course, String name) {
		course.setName(name);
	}
	
	/**
	 * Update subject for the specific course passed
	 * 
	 * @param course
	 * @param subject
	 */
	@Transactional
	public void updateSubject(Course course, Subject subject) {
		course.setSubject(subject);
	}
	
//	Unnecessary complexity
//	//update methods combined:
//	public void updateCourse(String course_id, String name, Subject subject) {
//		updateName(course_id, name);
//		updateSubject(course_id, subject);
//	}
	
	/**
	 * Delete the specific course passed
	 * 
	 * @param course
	 */
	@Transactional
	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}
	
	/**
	 * Delete specific course with the given course_id
	 * 
	 * @param course_id of the course to delete
	 * 
	 * @exception NullPointerException if course with that course_id does not exist
	 * 
	 */
	@Transactional
	public void deleteCourse(String course_id) {
		getCourse(course_id); //throw exception if course DNE
		courseRepository.deleteById(course_id);
	}
	
	/**
	 * Delete specific course with a given name and a given subject
	 * 
	 * @param name
	 * @param subject
	 * 
	 * @exception NullPointerException if course with that name and that subject does not exist
	 * 
	 */
	@Transactional
	public void deleteCourse(String name, Subject subject) {
		Course course = getCourse(name, subject);
		courseRepository.deleteById(course.getCourse_id());
	}
	
	/**
	 * Delete all courses with a given subject
	 * 
	 * @param subject
	 */
	@Transactional
	public void deleteCourses(Subject subject) {
		for (Course course : getCourses(subject)) {
			deleteCourse(course);
		}
	}
	
//	//function for getAllCourses
//	private <T> List<T> toList(Iterable<T> iterable){
//    	List<T> resultList = new ArrayList<T>();
//    	for (T t : iterable) {
//    	resultList.add(t);
//    	}
//    	return resultList;
//    	}
}
