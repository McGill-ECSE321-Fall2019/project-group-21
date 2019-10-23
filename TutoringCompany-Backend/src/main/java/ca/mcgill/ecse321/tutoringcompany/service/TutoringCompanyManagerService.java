package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyManagerService {

    @Autowired
     ManagerRepository managerRepository;
   
 
    @Transactional
    public Manager createManager(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
        Manager manager = new Manager();
       
       manager.setFirst_name(FirsName);
       manager.setLast_name(LastName);
       manager.setEmail(Email);
       manager.setPhone_number(PhoneNumber);
       manager.setPassword(Password);
        managerRepository.save(manager);
        return manager;
    }
    @Transactional
    public void deleteManager(String Email) {
    	managerRepository.delete(getmanager(Email));
    	
	}
    @Transactional
    public void updateManager(String currentEmail, String FirsName, String LastName, String PhoneNumber, String Password) {
    	getmanager(currentEmail).setFirst_name(FirsName);
    	getmanager(currentEmail).setLast_name(LastName);
    	getmanager(currentEmail).setPhone_number(PhoneNumber);
    	getmanager(currentEmail).setPassword(Password);
    	
	}
    @Transactional
    public void updateManagerPassword(String currentEmail,String Password) {
    	getmanager(currentEmail).setPassword(Password);
    	
	}
    @Transactional
    public void updateManagerFirstName(String currentEmail, String FirsName) {
    	getmanager(currentEmail).setFirst_name(FirsName);
  	
	}
    @Transactional
    public void updateManagerLastName(String currentEmail, String LastName) {
    	getmanager(currentEmail).setLast_name(LastName);
  	
	}
    /***
     * assign to group session  -- @Todo
     * 
     * 
     */
    
    /***
     * make sure correct form information is entered  -- @Todo
     * 
     * 
     */
    
    /***
     * check if email is existed in the database.  -- @Todo
     * 
     * 
     *
     */
    
    @Transactional
    public Manager getmanager(String email) {
    Manager manager = managerRepository.findByEmail(email);
    return manager;
    }
   
    
    
    
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

}
