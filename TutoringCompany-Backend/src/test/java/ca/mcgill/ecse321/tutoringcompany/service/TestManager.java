package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.tutoringcompany.model.*;
import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestManager {

	@InjectMocks
	private TutoringCompanyManagerService ManagerService;

	@Mock
	private ManagerRepository managerRepository;
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String Email = "manager@email.com";
	private static final String phoneNumber = "4500000000";
	private static final String Password = "123456";

	@Before
	public void mockSetUp() {
		when(managerRepository.save(any(Manager.class))).thenAnswer((InvocationOnMock invocation) -> {
			Manager manager = new Manager();
			manager.setFirst_name(FIRST_NAME);
			manager.setLast_name(LAST_NAME);
			manager.setEmail(Email);
			manager.setPassword(Password);
			manager.setPhone_number(phoneNumber);
			return manager;
		});
		when(managerRepository.findByEmail(anyString())).thenAnswer((InvocationOnMock invocation) -> {

			if (invocation.getArgument(0).equals(Email)) {
				Manager manager = new Manager();
				manager.setFirst_name(FIRST_NAME);
				manager.setLast_name(LAST_NAME);
				manager.setEmail(Email);
				manager.setPassword(Password);
				manager.setPhone_number(phoneNumber);
				return manager;
			}

			else {
				return null;
			}
		});

	}

	/**
	 * Create a manager
	 * 
	 * @result Manager will be persisted without any errors
	 */
	@Test
	public void testCreateManager() {
		try {
			ManagerService.createManager(FIRST_NAME, LAST_NAME, Email, phoneNumber, Password);
		} catch (IllegalArgumentException e) {
			fail();
		}

		Manager m = ManagerService.getManager(Email);
		assertEquals(FIRST_NAME, m.getFirst_name());
		assertEquals(LAST_NAME, m.getLast_name());
		assertEquals(Email, m.getEmail());
		assertEquals(phoneNumber, m.getPhone_number());
		assertEquals(Password, m.getPassword());

	}

	/**
	 * Create a manager with a null name
	 * 
	 * @result Manager will not be created due to an error
	 */
	@Test
	public void testCreateManagerNull() {

		String firstName = null;
		String error = null;
		try {
			ManagerService.createManager(firstName, "lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your manager details are incomplete!", error);

	}

	/**
	 * Create a manager with a space as it's first name
	 * 
	 * @result Manager will not be created due to an error
	 */
	@Test
	public void testCreateManagerSpaces() {

		String firstName = " ";
		String error = null;
		try {
			ManagerService.createManager(firstName, "lName", "mail@mail.com", "pNum", "pWord");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your manager details are incomplete!", error);

	}
}