package ca.mcgill.ecse321.tutoringcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringcompany.dto.ManagerDto;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;

@CrossOrigin(origins = "*")
@RestController
public class TutoringCompanyRestController {
	@Autowired
	TutoringCompanyManagerService managerService;
	@Autowired
	TutoringCompanyTutorService tutorService;
	
	/**
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/createManager", "/createManager/" })
	public ManagerDto createManager(@RequestParam(name = "firstName") String FirstName,
	@RequestParam(name = "lastName") String LastName,
	@RequestParam(name = "email") String Email, 
	@RequestParam(name = "phonenumber") String PhoneNumber, 
	@RequestParam(name = "password") String Password)
    throws IllegalArgumentException {
		Manager manager = managerService.createManager(FirstName, LastName, Email, PhoneNumber, Password);
		return convertToDto(manager);
	}
	private ManagerDto convertToDto(Manager manager) {
		if (manager == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		ManagerDto managerDto = new ManagerDto(manager.getFirst_name(),manager.getLast_name(),
				manager.getEmail(),manager.getPhone_number(), manager.getPassword());
		return managerDto;
	}
	/**
	 * 
	 * @param Email
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/deleteManager", "/deleteManager/" })
	public void deleteManager(
	@RequestParam(name = "email") String Email)throws IllegalArgumentException {
		 managerService.deleteManager(Email);
	}
	/**
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/updateManager", "/updateManager/" })
	public void updateManager(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName,
			@RequestParam(name = "email") String Email, 
			@RequestParam(name = "phonenumber") String PhoneNumber, 
			@RequestParam(name = "password") String Password)
		    throws IllegalArgumentException {
		 managerService.updateManager(Email, FirstName, LastName, PhoneNumber, Password);
}	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/getManager/{email}", "/getManager/{email}/" })
	  public ManagerDto getManager(@PathVariable("email") String email) throws
	IllegalArgumentException {
	  // @formatter:on
	  Manager manager = managerService.getmanager(email);
	  return convertToDto(manager);
	  }
	/**
	 * 
	 * @param Email
	 * @param Password
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/updateManagerPassword", "/updateManagerPassword/" })
	public void updateManagerPassword(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "password") String Password)
		    throws IllegalArgumentException {
		 managerService.updateManagerPassword(Email, Password);
}	
	/**
	 * 
	 * @param Email
	 * @param FirstName
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/updateManagerFirstName", "/updateManagerFirstName/" })
	public void updateManagerFirstName(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "firstName") String FirstName)
		    throws IllegalArgumentException {
		 managerService.updateManagerFirstName(Email, FirstName);
}	
	/**
	 * 
	 * @param Email
	 * @param LastName
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/updateManagerLastName", "/updateManagerLastName/" })
	public void updateManagerLastName(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "lastName") String LastName)
		    throws IllegalArgumentException {
		 managerService.updateManagerLastName(Email, LastName);
}	
//	@PostMapping(value = { "/Elias", "/Elias/" })
//	public void updateManagerLastName(@RequestParam(name = "firstName") String FirstName)
//		    throws IllegalArgumentException {
//		 managerService.find();
//}	
}