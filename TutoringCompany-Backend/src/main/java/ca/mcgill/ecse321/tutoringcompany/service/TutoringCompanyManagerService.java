package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyManagerService {
	  @Autowired
	    TutorRepository tutorRepository;
	    @Autowired
		TutoringCompanyTutorService tutorService;
    @Autowired
     ManagerRepository managerRepository;
   
    /*------- Creation methods -------*/
    /**
     * Create Manager instance with the given parameters, save it, and return it
     * 
     * @param first_name : first name of the manager that will be created
     * @param last_name : last name of the manager that will be created
     * @param email    : email address of the manager that will be created 
     * @param PhoneNumber : phone number of the manager that will be created
     * @param Password : password of the manager that will be created
     * @return the created manager
     * @exception EntityExistsException if a manager by the same email exists
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public Manager createManager(String first_name, String last_name, String email, String phone_number, String password) {
    	managerUnique(email);
    	managerValid(first_name, last_name, email, phone_number, password);
       Manager manager = new Manager();
       manager.setEmail(email);
       manager.setFirst_name(first_name);
       manager.setLast_name(last_name);
       manager.setPhone_number(phone_number);
       manager.setPassword(password);
        managerRepository.save(manager);
        return manager;
    }
    
    /*-------  Delete methods -------*/
    
    /**
     * Delete specific manager with the given email
     * 
     * @param email: email address of the manager to delete
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public void deleteManager(String email) {
    	managerExist(email);
    	managerRepository.delete(getManager(email));
	}
    /*------- Update methods -------*/
    
    /**
     * Update all information for the manager with the given email
     * 
     * @param email: email address of the manager whose information is to be updated
     * @param first_name: new first name
     * @param last_name: new last name
     * @param PhoneNumber: new phone number
     * @param Password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManager(String email, String first_name, String last_name, String PhoneNumber, String Password) {
    	managerExist(email);
    	managerValid(first_name, last_name, email, PhoneNumber, Password);
    	Manager manager = getManager(email);
    	manager.setFirst_name(first_name);
    	manager.setLast_name(last_name);
    	manager.setPhone_number(PhoneNumber);
    	manager.setPassword(Password);
	}
    
    /**
     * Update password for the specific manager whose email is given
     * 
     * @param email: email address of the manager whose password is to be updated
     * @param password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerPassword(String email, String password) {
    	 managerExist(email);
     	if (password == null || password.trim().length() == 0) {
     		throw new IllegalArgumentException("Your Password input is not correct");
     	}
    	getManager(email).setPassword(password);
	}
    
    /**
     * Update first name for the specific manager whose email is given
     * 
     * @param email: email address of the manager whose first name is to be updated
     * @param first_name: new first name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerFirstName(String email, String first_name) {
   	 managerExist(email);
	 if (first_name == null || first_name.trim().length() == 0) {
 		throw new IllegalArgumentException("Your first name input is not correct");
 	}
    	getManager(email).setFirst_name(first_name);
	}
    
    /**
     * Update first name for the specific manager whose email is given
     * 
     * @param email: email address of the manager that we will update his/her last name
     * @param last_name: new last name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerLastName(String email, String last_name) {
   	 managerExist(email);
	 if (last_name == null || last_name.trim().length() == 0) {
  		throw new IllegalArgumentException("Your last name input is not correct");
  	}
    	getManager(email).setLast_name(last_name);
	}
    
    /*------- Get methods -------*/

    /**
     * Read a specific manager by its email
     * 
     * @param email: email address of the manager that will be returned
     * @return manager
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public Manager getManager(String email) {
   	 managerExist(email);
    Manager manager = managerRepository.findByEmail(email);
    return manager;
    }
    
    /**
     * Read a list of all managers in the repository
     * @return list of all managers
     */
    @Transactional
    public List<Manager> getAllManagers() {
    return toList(managerRepository.findAll());
    }
    
 /*------- Other methods---------*/
    
    
   public ArrayList<Manager> find() {
	   
    	List <Manager> all = getAllManagers();
    	ArrayList<Manager> results = new ArrayList<Manager>();
    	
    	for (Manager m : all) {
    		if(m.getFirst_name().equalsIgnoreCase("elias")) {
    			results.add(m);
    		}
        
        	}
	    return results;
	    }
   
   private <T> List<T> toList(Iterable<T> iterable){
   	List<T> resultList = new ArrayList<T>();
   	for (T t : iterable) {
   	resultList.add(t);
   	}
   	return resultList;
   	}
    /*------- Assert methods -------*/
/**
 * Ensures that manager by the given email is unique or throws exception
 * 
 * @param email: email address of manager
 * @exception EntityExistsException if manager already exists 
 */
    @Transactional
    public void managerUnique(String email) {
      if (managerRepository.existsById(email))
        throw new EntityExistsException("manager Already Exists");
    }
    /**
     * Ensures that manager by the given email already exists or throws exception
     * 
     * @param : email address of manager
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public void managerExist(String email) {
      if (managerRepository.existsById(email)==false)
        throw new NullPointerException("manager Does not Exist");
    }
    
    /**
     * Ensures that manager info given is valid or throws exception
     * 
     * @param first_name
     * @param last_name
     * @param Email
     * @param PhoneNumber
     * @param Password
     * @exception InvalidParameterException if any of the given parameters are invalid (null or length 0 after trim)
     */
     private void managerValid(String first_name, String last_name, String Email, String PhoneNumber, String Password) {
     	    if (first_name == null || first_name.trim().length() == 0 ||last_name == null || last_name.trim().length() == 0 ||  
     	    		Email == null|| Email.trim().length() == 0 || PhoneNumber == null || PhoneNumber == null ||
     	    				Password ==null   || Password.trim().length() == 0) {
     	      throw new IllegalArgumentException("Your manager details are incomplete!");
     	    }
     }
}
