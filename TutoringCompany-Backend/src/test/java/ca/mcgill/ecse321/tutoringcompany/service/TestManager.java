package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManager {
	
	@Autowired
	private TutoringCompanyManagerService ManagerService;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Before
	public void clearDatabase() {
		managerRepository.deleteAll();
	}
	
	/**
	 * Create a manager
	 * @result Manager will be persisted without any errors
	 */
	@Test
	public void testCreateManager(){
		assertEquals(0, ManagerService.getAllManagers().size());
		String firstName = "fName";
		try {
			ManagerService.createManager(firstName, "lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Manager> allManagers = ManagerService.getAllManagers();
		assertEquals(1, allManagers.size());
		assertEquals(firstName, allManagers.get(0).getFirst_name());
	}
	
	/**
	 * Create a manager with a null name
	 * @result Manager will not be created due to an error
	 */
	@Test
	public void testCreateManagerNull() {
		assertEquals(0, ManagerService.getAllManagers().size());
		String firstName = null;
		String error = null;
		try {
			ManagerService.createManager(firstName, "lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your manager details are incomplete!", error);
		assertEquals(0, ManagerService.getAllManagers().size());
	}
	
	/**
	 * Create a manager with an empty name
	 * @result Manager will not be created due to an error
	 */
	@Test
	public void testCreateManagerEmpty() {
		assertEquals(0, ManagerService.getAllManagers().size());
		String firstName = "";
		String error = null;
		try {
			ManagerService.createManager(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your manager details are incomplete!", error);
		assertEquals(0, ManagerService.getAllManagers().size());
	}
	
	/**
	 * Create a manager with a space as it's first name
	 * @result Manager will not be created due to an error
	 */
	@Test
	public void testCreateManagerSpaces() {
		assertEquals(0, ManagerService.getAllManagers().size());
		String firstName = " ";
		String error = null;
		try {
			ManagerService.createManager(firstName,"lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your manager details are incomplete!", error);
		assertEquals(0, ManagerService.getAllManagers().size());
	}
	
	/**
	 * Delete a manager
	 * @result Manager will be deleted without any errors
	 */
	@Test
	public void testDeleteManager() {
		assertEquals(0, ManagerService.getAllManagers().size());
		testCreateManager();
		assertEquals(1, ManagerService.getAllManagers().size());
		try {
			ManagerService.deleteManager("mail@mail.com");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, ManagerService.getAllManagers().size());
	}
	
	/**
	 * Update a Manager
	 * @result Manager will be updated without any errors
	 */
	@Test
	public void testUpdateManager() {
		
		assertEquals(0, ManagerService.getAllManagers().size());
		
		String firstName1 = "fName1";
		String firstName2 = "fName2";
		String lastName1 = "lName1";
		String lastName2 = "lName2";
		String email = "mail@mail.com";
		String phoneNum1 = "pNum1";
		String phoneNum2 = "pNum2";
		String password1 = "pWord1";
		String password2 = "pWord2";
		
//		try {
//			ManagerService.createManager(firstName1, lastName1, email, phoneNum1, password1);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
		try {
			testCreateManager();
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		ManagerService.updateManager(email, firstName2, lastName2, phoneNum2, password2);
		
		List<ca.mcgill.ecse321.tutoringcompany.model.Manager> allManagers = ManagerService.getAllManagers();
		ca.mcgill.ecse321.tutoringcompany.model.Manager manager = allManagers.get(0);
		
		assertEquals(firstName2, manager.getFirst_name());
		assertEquals(lastName2, manager.getLast_name());
		assertEquals(phoneNum2, manager.getPhone_number());
		assertEquals(password2, manager.getPassword());
	}
}