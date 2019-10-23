package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyTutorService {
	 @Autowired
     TutorRepository tutorRepository;
	 
	 @Transactional
	    public Tutor createTutor(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
	        Tutor tutor = new Tutor();
	       
	       tutor.setFirst_name(FirsName);
	       tutor.setLast_name(LastName);
	       tutor.setEmail(Email);
	       tutor.setPhone_number(PhoneNumber);
	       tutor.setPassword(Password);
	        tutorRepository.save(tutor);
	        return tutor;
	    }
	 
	    @Transactional
	    public void deleteTutor(String Email) {
	    	tutorRepository.delete(getTutor(Email));
	    	
		}
	    @Transactional
	    public void updateTutor(String currentEmail, String FirsName, String LastName, String PhoneNumber, String Password) {
	    	getTutor(currentEmail).setFirst_name(FirsName);
	    	getTutor(currentEmail).setLast_name(LastName);
	    	getTutor(currentEmail).setPhone_number(PhoneNumber);
	    	getTutor(currentEmail).setPassword(Password);
	    	
		}
	    @Transactional
	    public void updateStudentPassword(String currentEmail,String Password) {
	    	getTutor(currentEmail).setPassword(Password);
	    	
		}
	    @Transactional
	    public void updateStudentFirstName(String currentEmail, String FirsName) {
	    	getTutor(currentEmail).setFirst_name(FirsName);
	  	
		}
	    @Transactional
	    public void updateStudentLastName(String currentEmail, String LastName) {
	    	getTutor(currentEmail).setLast_name(LastName);
	  	
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
	    
	    /**
	     * Change availabilities -- @Todo
	     * 
	     * 
	     */
	    
	    @Transactional
	    public Tutor getTutor(String email) {
	    Tutor tutor = tutorRepository.findByEmail(email);
	    return tutor;
	    }
	   
	    
	    
	    
	    @Transactional
	    public List<Tutor> getAllTutors() {
	    return toList(tutorRepository.findAll());
	    }
	    private <T> List<T> toList(Iterable<T> iterable){
	    	List<T> resultList = new ArrayList<T>();
	    	for (T t : iterable) {
	    	resultList.add(t);
	    	}
	    	return resultList;
	    	}

	    
	   

}
