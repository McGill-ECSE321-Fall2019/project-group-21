package ca.mcgill.ecse321.tutoringcompany.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.dto.ManagerDto;
import ca.mcgill.ecse321.tutoringcompany.dto.TutorDto;
//import ca.mcgill.ecse321.tutoringcompany.dto.TutorDto;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;
/**
 * 
 * @author Elias Tamrazs
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class TutoringCompanyRestController {
	@Autowired
	TutoringCompanyManagerService managerService;
	@Autowired
	TutoringCompanyTutorService tutorService;
	@Autowired
	ManagerRepository managerRepository;
	/**
	 * This method creates a new manager
	 * ***Important Note***
	 * This method does not require a manager email and password temporarily 
	 * because the database is not stable but eventually will have when the data base is finally set 
	 * with the default manager
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @return the created manager
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/Manager/Create", "/Manager/Create/" })
	public Manager createManager(@RequestParam(name = "firstName") String FirstName,
	@RequestParam(name = "lastName") String LastName,
	@RequestParam(name = "email") String Email, 
	@RequestParam(name = "phonenumber") String PhoneNumber, 
	@RequestParam(name = "password") String Password)
    throws IllegalArgumentException {
		Manager manager = managerService.createManager(FirstName, LastName, Email, PhoneNumber, Password);
		return manager;
	}
	/**
	 * This method can only be executed by an existing Manager to delete a manager
	 * @param Email: email of the manager that will be deleted
	 * @exception InvalidParameterException if Email == null or the length of the String email ==0
	 * @exception NullPointerException if the email of the manager that will be deleted does not exist
	 * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
	 * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/Delete", "/Manager/Delete/" })
	public void deleteManager(
	@RequestParam(name = "email") String Email,@RequestParam(name = "ManagerEmail") String ManagerEmail,
    @RequestParam(name = "ManagerPassword") String ManagerPassword)throws IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		 managerService.deleteManager(Email);
	}
	/**
	 * This method can only be executed by an existing Manager to update a manager's all information
     * @param currentEmail: email address of the manager that we will update his/her information
     * @param FirsName: new first name
     * @param LastName: new last name
     * @param PhoneNumber: new phone number
     * @param Password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
	 * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/Update", "/Manager/Update/" })
	public void updateManager(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName,
			@RequestParam(name = "email") String Email, 
			@RequestParam(name = "phonenumber") String PhoneNumber, 
			@RequestParam(name = "password") String Password, @RequestParam(name = "ManagerEmail") String ManagerEmail,
		    @RequestParam(name = "ManagerPassword") String ManagerPassword)
		    throws IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		 managerService.updateManager(Email, FirstName, LastName, PhoneNumber, Password);
}	
    /**
     * This method can only be executed by an existing Manager to return a manager by giving his/her email
     * @param email: email address of the manager that will be returned
     * @return manager
     * @exception NullPointerException if manager does not exist
     * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
     * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
     */
	@PostMapping(value = { "/Manager/getManager", "/Manager/getManager/" })
	  public ManagerDto getManager(@RequestParam("email") String email,@RequestParam(name = "ManagerEmail") String ManagerEmail,
			    @RequestParam(name = "ManagerPassword") String ManagerPassword) throws
	IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
	  Manager manager = managerService.getmanager(email);
	  return convertToDto(manager);
	  }
	/**
	 * This method can only be executed by an existing Manager to update a manager's password
     * @param currentEmail: email address of the manager that we will update his/her password
     * @param Password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
	 * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
     * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/Update/Password", "/Manager/Update/Password/" })
	public void updateManagerPassword(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "password") String Password,@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws
			IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		    managerService.updateManagerPassword(Email, Password);
		}	
	
   /**
	 * This method can only be executed by an existing Manager to update a manager's first name
     * @param currentEmail: email address of the manager that we will update his/her first name
     * @param FirstName: new first name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
	 * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
     * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/Update/FirstName", "/Manager/Update/FirstName/" })
	public void updateManagerFirstName(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "firstName") String FirstName,@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws
			IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		 managerService.updateManagerFirstName(Email, FirstName);
}	
   /**
     * this method can only be executed by an existing Manager to update a manager's last name
     * @param currentEmail: email address of the manager that we will update his/her last name
     * @param LastName: new last name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     * The following exceptions make sure that only a manager can execute this method by taking his/her
	 * email and password
     * @param ManagerEmail : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException if the the manager (who executes this method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
     */
	@PostMapping(value = { "/Manager/update/LastName", "/Manager/update/LastName/" })
	public void updateManagerLastName(@RequestParam(name = "email") String Email, 
			@RequestParam(name = "lastName") String LastName,@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws
			IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		 managerService.updateManagerLastName(Email, LastName);
}
	 /**
	  * 
	  * this method can only be executed by an existing Manager to create a new tutor and save it in the tutor repository
	  * @param FirsName : first name of the tutor that will be created
	  * @param LastName : last name of the tutor that will be created
	  * @param Email    : email address of the tutor that will be created 
	  * @param PhoneNumber : phone number of the tutor that will be created
	  * @param Password : password of the tutor that will be created
	  * @return the created tutor
	  * @exception EntityExistsException if the tutor is existed or the email is used
	  * @exception InvalidParameterException if any of the previous parameters equals to null or 
	  * the string length equals to zero
	  *The following exceptions make sure that only a manager can execute this method by taking his/her
      * email and password
      * @param ManagerEmail : email address of the manager uses this method
	  * @param ManagerPassword: pass word the same manager
	  * @exception NullPointerException if the the manager (who executes this method) email does not exist
	  * @exception InvalidParameterException if the manager password is wrong
	  */
	 @PostMapping(value = { "/Manager/Create/Tutor", "/Manager/Create/Tutor/" })
	 public TutorDto createTutor(@RequestParam(name = "firstName") String FirstName,
	 @RequestParam(name = "lastName") String LastName,
	 @RequestParam(name = "email") String Email, 
	 @RequestParam(name = "phonenumber") String PhoneNumber, 
	 @RequestParam(name = "password") String Password,@RequestParam(name = "ManagerEmail") String ManagerEmail,
	 @RequestParam(name = "ManagerPassword") String ManagerPassword) throws
	 IllegalArgumentException {
		 if(!managerRepository.existsById(ManagerEmail)){
		 throw new NullPointerException("manager Does not Exist");
		 }
		 if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
		 throw new InvalidParameterException("Incorrect Password");
		 }
     Tutor tutor = tutorService.createTutor(FirstName, LastName, Email, PhoneNumber, Password);
	 return convertToDto(tutor);
	}	 
	 /**
	  * @Identifier F3
	  * this method can only be executed by an existing Manager to verify a tutor by the manager 
      * after doing the interview
      * @param email: email of the tutor that will be verified
      * @exception NullPointerException if tutor does not exist
	  * The following exceptions make sure that only a manager can execute this method by taking his/her
      * email and password
      * @param ManagerEmail : email address of the manager uses this method
	  * @param ManagerPassword: pass word the same manager
	  * @exception NullPointerException if the the manager (who executes this method) email does not exist
	  * @exception InvalidParameterException if the manager password is wrong
	  */
	 @PostMapping(value = { "/Manager/VerifyTutor", "/Tutor/Verify/Tutor/" })
		public Tutor verifyTutor (@RequestParam(name = "email") String Email,@RequestParam(name = "ManagerEmail") String ManagerEmail,
		@RequestParam(name = "ManagerPassword") String ManagerPassword) throws
		IllegalArgumentException {
		 if(!managerRepository.existsById(ManagerEmail)){
		 throw new NullPointerException("manager Does not Exist");
		 }
		 if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
		 throw new InvalidParameterException("Incorrect Password");
		 }
		tutorService.getTutor(Email).setVerified(true);
		return tutorService.getTutor(Email);
		
	}
	/**
	  * this method can only be executed by an existing Manager to return all the verified tutors
      * @return a list a verified tutors
	  * The following exceptions make sure that only a manager can execute this method by taking his/her
      * email and password
      * @param ManagerEmail : email address of the manager uses this method
	  * @param ManagerPassword: pass word the same manager
	  * @exception NullPointerException if the the manager (who executes this method) email does not exist
	  * @exception InvalidParameterException if the manager password is wrong
	  */
	@PostMapping(value = { "/Manager/get/VerifiedTutors", "/Manager/get/VerifiedTutors/" })
	public ArrayList<Tutor> getVerifiedTutors(@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws
			IllegalArgumentException {
		if(!managerRepository.existsById(ManagerEmail)){
			 throw new NullPointerException("manager Does not Exist");
			 }
			 if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			 throw new InvalidParameterException("Incorrect Password");
			 }
		return managerService.getVerifiedTutors();
}

	 /**
	  * @Identifier F6
	  * this method can only be executed by an existing Manager to return a tutor by giving his/her email
      * @param email: email address of the tutor that will be returned
      * @return tutor
      * @exception NullPointerException if tutor does not exist
	  * The following exceptions make sure that only a manager can execute this method by taking his/her
      * email and password
      * @param ManagerEmail : email address of the manager uses this method
	  * @param ManagerPassword: pass word the same manager
	  * @exception NullPointerException if the the manager (who executes this method) email does not exist
	  * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/get/Tutor", "/Manager/get/Tutor/" })
	  public TutorDto getTutor(@RequestParam(name = "email") String Email,@RequestParam(name = "ManagerEmail") String ManagerEmail,
	 @RequestParam(name = "ManagerPassword") String ManagerPassword ) throws
	IllegalArgumentException {
	  // @formatter:on
		if(!managerRepository.existsById(ManagerEmail)){
			throw new NullPointerException("manager Does not Exist");
		}
		if(!managerService.getmanager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
	  Tutor tutor = managerService.getTutor(Email);
	  return convertToDto(tutor);
	  }
	
	
	private TutorDto convertToDto(Tutor tutor) {
		if (tutor == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		TutorDto tutorDto = new TutorDto(tutor.getFirst_name(),tutor.getLast_name(),
				tutor.getEmail(),tutor.getPhone_number(), tutor.getPassword());
		return tutorDto;
	}
	private ManagerDto convertToDto(Manager manager) {
		if (manager == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		ManagerDto managerDto = new ManagerDto(manager.getFirst_name(),manager.getLast_name(),
				manager.getEmail(),manager.getPhone_number(), manager.getPassword());
		return managerDto;
	}
}

