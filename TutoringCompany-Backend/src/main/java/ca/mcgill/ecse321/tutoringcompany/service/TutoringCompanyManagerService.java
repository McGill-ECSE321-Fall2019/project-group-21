package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
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
     ManagerRepository managerRepository;
   
    /*------- Creation methods -------*/
    /**
     * this method creates a new manager and save it in the manager repository
     * @param FirsName : first name of the manager that will be created
     * @param LastName : last name of the manager that will be created
     * @param Email    : email address of the manager that will be created 
     * @param PhoneNumber : phone number of the manager that will be created
     * @param Password : password of the manager that will be created
     * @return the created manager
     * @exception EntityExistsException if the manager is existed or the email is used
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public Manager createManager(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
    	containsManager(Email);
    	if  (incorrectManagerDetails(FirsName, LastName, Email, PhoneNumber, Password)) {
    		throw new InvalidParameterException("Your manager details are incomplete!");
    	}
       Manager manager = new Manager();
       manager.setFirst_name(FirsName);
       manager.setLast_name(LastName);
       manager.setEmail(Email);
       manager.setPhone_number(PhoneNumber);
       manager.setPassword(Password);
        managerRepository.save(manager);
        return manager;
    }
    /*-------  Delete methods -------*/
    
    /**
     * this method deletes manager giving his email address
     * @param Email: email address of the manager that will be deleted 
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public void deleteManager(String Email) {
    	managerNotExisted(Email);
    	managerRepository.delete(getmanager(Email));
	}
    /*------- Update methods -------*/
    
    /**
     * this method updates the manager's all information
     * @param currentEmail: email address of the manager that we will update his/her information
     * @param FirsName: new first name
     * @param LastName: new last name
     * @param PhoneNumber: new phone number
     * @param Password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManager(String currentEmail, String FirsName, String LastName, String PhoneNumber, String Password) {
    	managerNotExisted(currentEmail);
    	if (incorrectManagerDetails(FirsName, LastName, currentEmail, PhoneNumber, Password)) {
    		throw new InvalidParameterException("Your manager details are incomplete!");
    	}
    	getmanager(currentEmail).setFirst_name(FirsName);
    	getmanager(currentEmail).setLast_name(LastName);
    	getmanager(currentEmail).setPhone_number(PhoneNumber);
    	getmanager(currentEmail).setPassword(Password);
    	
	}
    /**
     * this method updates the manager's password
     * @param currentEmail: email address of the manager that we will update his/her password
     * @param Password: new password
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerPassword(String currentEmail,String Password) {
    	 managerNotExisted(currentEmail);
     	if (Password == null || Password.trim().length() == 0) {
     		throw new InvalidParameterException("Your Password input is not correct");
     	}
    	getmanager(currentEmail).setPassword(Password);
	}
    /**
     * this method updates the manager's first name
     * @param currentEmail: email address of the manager that we will update his/her first name
     * @param FirstName: new first name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerFirstName(String currentEmail, String FirsName) {
   	 managerNotExisted(currentEmail);
	 if (FirsName == null || FirsName.trim().length() == 0) {
 		throw new InvalidParameterException("Your FirsName input is not correct");
 	}
    	getmanager(currentEmail).setFirst_name(FirsName);
	}
    /**
     * this method updates the manager's last name
     * @param currentEmail: email address of the manager that we will update his/her last name
     * @param LastName: new last name
     * @exception NullPointerException if manager does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateManagerLastName(String currentEmail, String LastName) {
   	 managerNotExisted(currentEmail);
	 if (LastName == null || LastName.trim().length() == 0) {
  		throw new InvalidParameterException("Your FirsName input is not correct");
  	}
    	getmanager(currentEmail).setLast_name(LastName);
	}
    /*------- Get methods -------*/

    /**
     * this method returns a manager by giving his/her email
     * @param email: email address of the manager that will be returned
     * @return manager
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public Manager getmanager(String email) {
   	 managerNotExisted(email);
    Manager manager = managerRepository.findByEmail(email);
    return manager;
    }
    /**
     * this method returns a list of all the managers in the manager repository
     * @return list of all managers
     */
    @Transactional
    public List<Manager> getAllManagers() {
    return toList(managerRepository.findAll());
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
 * throws an exception if manager already exists
 * @param email: email address of manager
 * @exception EntityExistsException if manager already exists 
 */
    @Transactional
    public void containsManager(String email) {
      if (managerRepository.existsById(email))
        throw new EntityExistsException("manager Already Exists");
    }
    /**
     * throws an exception if manager does not exist
     * @param : email address of manager
     * @exception NullPointerException if manager does not exist
     */
    @Transactional
    public void managerNotExisted(String email) {
      if (managerRepository.existsById(email)==false)
        throw new NullPointerException("manager Does not Exist");
    }
    
   /**
    * this method makes sure that the input follows the correct pattern
    * @param FirsName
    * @param LastName
    * @param Email
    * @param PhoneNumber
    * @param Password
    * @return true if in input is not correct, false otherwise
    */
    private boolean incorrectManagerDetails(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
    	    if (FirsName == null || FirsName.trim().length() == 0 ||LastName == null || LastName.trim().length() == 0 ||  
    	    		Email == null|| Email.trim().length() == 0 || PhoneNumber == null || PhoneNumber == null ||
    	    				Password ==null   || Password.trim().length() == 0) {
    	      return true;
    	    }
    	    return false;
    	  }
    
    
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
}
