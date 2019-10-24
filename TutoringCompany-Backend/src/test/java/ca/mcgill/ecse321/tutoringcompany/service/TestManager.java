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

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManager {
	
	/**
	 * @Autowiring services
	 */
	
	@Autowired
	private TutoringCompanyManagerService ManagerService;
	
	/**
	 * @Autowiring repos
	 */
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Before
	public void clearDatabase() {
		managerRepository.deleteAll();
	}
	
	@Test
	public void testCreateManager(){
		assertEquals(0, ManagerService.getAllManagers().size());
		String firstName = "George";
		try {
			ManagerService.createManager(firstName, "kandalaft", "george@gmail.com", "4389883384", "123456");
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<ca.mcgill.ecse321.tutoringcompany.model.Manager> allManagers = ManagerService.getAllManagers();
		assertEquals(1, allManagers.size());
		assertEquals(firstName, allManagers.get(0).getFirst_name());
	}
	
	@Test
	public void testDeleteManager() {
		assertEquals(0, ManagerService.getAllManagers().size());
		try {
			ManagerService.createManager("Elias","k", "eliasi@gmail.com", "oj", "ijm");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(1, ManagerService.getAllManagers().size());
		ManagerService.deleteManager("eliasi@gmail.com");
		assertEquals(0, ManagerService.getAllManagers().size());
	}
	
	@Test
	public void testUpdateManager() {
		
		assertEquals(0, ManagerService.getAllManagers().size());
		
		String firstName = "Elias";
		String lastName = "Eliasso";
		String email = "eliasi@gmail.com";
		String phoneNum = "321";
		String password = "thepass";
		
		try {
			ManagerService.createManager("Caleb", "Lim", email, "123", "pass");
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		ManagerService.updateManager(email, firstName, lastName, phoneNum, password);
		
		List<ca.mcgill.ecse321.tutoringcompany.model.Manager> allManagers = ManagerService.getAllManagers();
		ca.mcgill.ecse321.tutoringcompany.model.Manager manager = allManagers.get(0);
		
		assertEquals(firstName, manager.getFirst_name());
		assertEquals(lastName, manager.getLast_name());
		assertEquals(phoneNum, manager.getPhone_number());
		assertEquals(password, manager.getPassword());
	}
}