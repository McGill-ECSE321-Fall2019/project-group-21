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

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
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
	 * Create Course instance with the given parameters, save it, and return it
	 *
	 * @param name
	 * @param subject
	 * @param course_id -- @PrimaryKey -- String that represents the course id
	 *  
	 * @return the created course
	 */
	@Transactional
	public Course createCourse(String name, Subject subject, String course_id) {
		courseValid(course_id, name, subject);
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
	 * @return course
	 */
	@Transactional
	public Course getCourse(String course_id) {
		//courseExist(course_id);
		return courseRepository.findById(course_id).get();
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
		for (Course course : courseRepository.findCourseBySubject(subject)) {
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
	
	@Transactional
	public ArrayList<Course> getAllCoursesBySubject(Subject subject) {
		List<Course> all = getAllCourses();
		
		ArrayList<Course> result = new ArrayList<Course>();
		for(Course course : all) {
			if (course.getSubject().equals(subject)) {
				result.add(course);
			}
		}
		return  result;
	}
	
	
	/**
	 * Update name for the specific course whose course_id is passed
	 * 
	 * @param course_id
	 * @param name
	 */
	@Transactional
	public void updateCourseName(String course_id, String name) {
		getCourse(course_id).setName(name);
		courseRepository.save(getCourse(course_id));
	}
	
	/**
	 * Update subject for the specific course whose course_id is passed
	 * 
	 * @param course_id
	 * @param subject
	 */
	@Transactional
	public void updateCourseSubject(String course_id, Subject subject) {
		getCourse(course_id).setSubject(subject);
		courseRepository.save(getCourse(course_id));
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
	
	/**
	 * Ensures that offering by the given id is unique or throws exception
	 * 
	 * @param course_id of course
	 * @exception EntityExistsException if course already exists
	 */
	@Transactional
    public void courseUnique(String course_id) {
      if (courseRepository.existsById(course_id))
        throw new EntityExistsException("offering Already Exists");
    }
	
    /**
     * Ensures that offering by the given id already exists or throws exception
     * 
     * @param course_id of course
     * @exception NullPointerException if course does not exist
     */
    @Transactional
    public void courseExist(String course_id) {
      if (! courseRepository.existsById(course_id))
        throw new NullPointerException("offering Does not Exist");
    }
    
    /**
     * Ensures that the course info given is valid or throws exception
     * 
     * @param course_id
     * @param name
     * @param subject
     * @exception IllegalArgumentException if any of the given parameters are invalid (null or length 0 after trim)
     */
    private void courseValid(String course_id, String name, Subject subject) {
 	    if (course_id == null || course_id.trim().length() == 0 || 
 	    		name == null || name.trim().length() == 0) {
 	      throw new IllegalArgumentException("Your course details are incomplete!");
 	    }
    }
}