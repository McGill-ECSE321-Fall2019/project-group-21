/* package TestPersistenceClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.CourseRepository;
import ca.mcgill.ecse321.tutoringcompany.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCourse {
	
	@Test
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());
		
		String name = "ECSE 321";
		Subject subject = new Subject();
		
		try {
			service.createCourse(name, subject);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		List<Course> allCourses = toList(CourseRepository.findAll());
		
		assertEquals(1, allCourses.size());
		assertEquals(name, allCourses.get(0).getName());
		
		CourseRepository.deleteAll();
	}
	
	@Test
	public void testReadCourse() {
		assertEquals(0, service.getAllCourses().size());
		
		String name = "ECSE 321";
		Subject subject = new Subject();
		subject.setName("subjectName");
		
		service.createCourse(name, subject);
		
		try {
			Course c = service.getCourse(name);
		} catch (IllegalArgumentException e){
			fail();
		}
		
		assertEquals(name, c.getName());
		assertEquals("subjectName", c.getSubject().getName());
		
		CourseRepository.deleteAll();
	}

}

*/