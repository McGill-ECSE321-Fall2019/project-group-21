package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.catalina.Manager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;


/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCourse {

	@Autowired
	private TutoringCompanyCourseService CourseService;

	@Autowired
	private CourseRepository courseRepository;
	
	@Before
	public void clearDatabase() {
		courseRepository.deleteAll();
	}
	
	/**
	 * Create a course
	 * @result Course will be persisted without any errors
	 */
	@Test
	public void testCreateCourse() {
		assertEquals(0, CourseService.getAllCourses().size());
		String name = "name";
		Subject subject = Subject.MATH;
		try {
			CourseService.createCourse(name, subject, "courseID");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Course> allcourses = CourseService.getAllCourses();
		assertEquals(1, allcourses.size());
		assertEquals(name, allcourses.get(0).getName());
	}
	
//	/**
//	 * Create a course with a null name
//	 * @result course will not be created due to an error
//	 */
//	@Test
//	public void testCreateCourseNull() {
//		assertEquals(0, CourseService.getAllCourses().size());
//		String name = null;
//		Subject subject = Subject.MATH;
//		String error = null;
//		try {
//			CourseService.createCourse(name, subject, "courseID");
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//		assertEquals("Your course details are incomplete!", error);
//		assertEquals(0, CourseService.getAllCourses().size());
//	}
//	
//	/**
//	 * Create a course with an empty name
//	 * @result course will not be created due to an error
//	 */
//	@Test
//	public void testCreateCourseEmpty() {
//		assertEquals(0, CourseService.getAllCourses().size());
//		String name = "";
//		Subject subject = Subject.MATH;
//		String error = null;
//		try {
//			CourseService.createCourse(name, subject, "courseID");
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//		assertEquals("Your course details are incomplete!", error);
//		assertEquals(0, CourseService.getAllCourses().size());
//	}
//	
//	/**
//	 * Create a course with a space as it's first name
//	 * @result course will not be created due to an error
//	 */
//	@Test
//	public void testCreateCourseSpaces() {
//		assertEquals(0, CourseService.getAllCourses().size());
//		String name = " ";
//		Subject subject = Subject.MATH;
//		String error = null;
//		try {
//			CourseService.createCourse(name, subject, "courseID");
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//		assertEquals("Your course details are incomplete!", error);
//		assertEquals(0, CourseService.getAllCourses().size());
//	}
	
	/**
	 * Delete a course
	 * @result course will be deleted without any errors
	 */
	@Test
	public void testDeleteCourse() {
		assertEquals(0, CourseService.getAllCourses().size());
		testCreateCourse();
		assertEquals(1, CourseService.getAllCourses().size());
		try {
			CourseService.deleteCourse("courseID");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, CourseService.getAllCourses().size());
	}

//	//TODO
//	/**
//	 * Update a course
//	 * @result course will be updated without any errors
//	 */
//	@Test
//	public void testUpdateCourse() {
//		
//		assertEquals(0, CourseService.getAllCourses().size());
//		
//		String name2 = "name2";
//		Subject subject1 = Subject.MATH;
//		Subject subject2 = Subject.PHYSICS;
//		String course = "ecse321";
//		
//		try {
//			CourseService.createCourse("name1",subject1, course);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		
//		CourseService.updateName(CourseService.getCourse("ecse321"), name2);
//		CourseService.updateSubject(CourseService.getCourse("ecse321"), subject2);
//		
//		List<Course> allcourses = CourseService.getAllCourses();
//		Course course1 = allcourses.get(0);
//		
//		assertEquals(name2, course1.getName());
//		assertEquals(subject2, course1.getSubject());
//	}
}