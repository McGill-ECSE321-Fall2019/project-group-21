/*package TestPersistenceClasses;

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

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {
	
	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size());
		
		String firstName = "fName";
		String lastName = "lName";
		String phone = "phone";
		String email = "email";
		String password = "password";
		
		try {
			service.createStudent(firstName, lastName, phone, email, password);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		List<Student> allStudents = toList(StudentRepository.findAll());
		
		assertEquals(1, allStudents.size());
		assertEquals(email, allStudents.get(0).getEmail());
		
		StudentRepository.deleteAll();
	}
	
	@Test
	public void testReadStudent() {
		assertEquals(0, service.getAllStudents().size());
		
		String firstName = "fName";
		String lastName = "lName";
		String phone = "phone";
		String email = "email";
		String password = "password";
		
		service.createStudent(firstName, lastName, phone, email, password);
		
		try {
			Student s = service.getStudent(email);
		} catch (IllegalArgumentException e){
			fail();
		}
		
		assertEquals(firstName, s.getFirstName());
		assertEquals(lastName, s.getLastName());
		assertEquals(phone, s.getPhone());
		assertEquals(email, s.getFirstName());
		assertEquals(password, s.getFirstName());
		
		StudentRepository.deleteAll();
	}

}

*/