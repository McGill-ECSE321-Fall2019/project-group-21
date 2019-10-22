package ca.mcgill.ecse321.tutoringcompany;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutoringCompanyApplicationTests {

	@Autowired
	private TutoringCompanyService service;
	@Autowired
	private StudentRepository studentRepository;

//	@After
//	public void clearDatabase() {
//	// Fisrt, we clear registrations to avoid exceptions due to inconsistencies
//	studentRepository.deleteAll();
//	
//	}
//	
	@Test
	public void testCreatePerson() {
		//studentRepository.deleteAll();
	assertEquals(0, service.getAllStudents().size());
	String name = "Oscar";
	try {
	service.createStudent(name,"hi", "kifak", "shu", "elakhbar");
	} catch (IllegalArgumentException e) {
	// Check that no error occurred
	fail();
	}
	List<Student> allPersons = service.getAllStudents();
	assertEquals(1, allPersons.size());
	assertEquals(name, allPersons.get(0).getFirst_name());
	}
	
	int y=0;


}
