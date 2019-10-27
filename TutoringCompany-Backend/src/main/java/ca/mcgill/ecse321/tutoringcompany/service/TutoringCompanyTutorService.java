package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
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

	/*------- Creation methods -------*/
	/**
	 * this method creates a new tutor and save it in the tutor repository
	 * 
	 * @param FirsName    : first name of the tutor that will be created
	 * @param LastName    : last name of the tutor that will be created
	 * @param Email       : email address of the tutor that will be created
	 * @param PhoneNumber : phone number of the tutor that will be created
	 * @param Password    : password of the tutor that will be created
	 * @return the created tutor
	 * @exception EntityExistsException     if the tutor is existed or the email is
	 *                                      used
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public Tutor createTutor(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
		containsTutor(Email);
		if (incorrectTutorDetails(FirsName, LastName, Email, PhoneNumber, Password)) {
			throw new InvalidParameterException("Your tutor details are incomplete!");
		}
		Tutor tutor = new Tutor();
		tutor.setFirst_name(FirsName);
		tutor.setLast_name(LastName);
		tutor.setEmail(Email);
		tutor.setPhone_number(PhoneNumber);
		tutor.setPassword(Password);
		tutorRepository.save(tutor);
		return tutor;
	}
	/*-------  Delete methods -------*/

	/**
	 * this method deletes tutor giving his email address
	 * 
	 * @param Email: email address of the tutor that will be deleted
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public void deleteTutor(String Email) {
		tutorNotExisted(Email);
		tutorRepository.delete(getTutor(Email));

	}
	/*------- Update methods -------*/

	/**
	 * this method updates the tutor's all information
	 * 
	 * @param currentEmail: email address of the tutor that we will update his/her
	 *                      information
	 * @param FirsName:     new first name
	 * @param LastName:     new last name
	 * @param PhoneNumber:  new phone number
	 * @param Password:     new password
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutor(String currentEmail, String FirsName, String LastName, String PhoneNumber,
			String Password) {
		tutorNotExisted(currentEmail);
		if (incorrectTutorDetails(FirsName, LastName, currentEmail, PhoneNumber, Password)) {
			throw new InvalidParameterException("Your tutor details are incomplete!");
		}
		getTutor(currentEmail).setFirst_name(FirsName);
		getTutor(currentEmail).setLast_name(LastName);
		getTutor(currentEmail).setPhone_number(PhoneNumber);
		getTutor(currentEmail).setPassword(Password);

	}

	/**
	 * this method updates the tutor's password
	 * 
	 * @param currentEmail: email address of the tutor that we will update his/her
	 *                      password
	 * @param Password:     new password
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorPassword(String currentEmail, String Password) {
		tutorNotExisted(currentEmail);
		if (Password == null || Password.trim().length() == 0) {
			throw new InvalidParameterException("Your Password input is not correct");
		}
		getTutor(currentEmail).setPassword(Password);
	}

	/**
	 * this method updates the tutor's first name
	 * 
	 * @param currentEmail: email address of the tutor that we will update his/her
	 *                      first name
	 * @param FirstName:    new first name
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorFirstName(String currentEmail, String FirsName) {
		getTutor(currentEmail).setFirst_name(FirsName);

	}

	/**
	 * this method updates the tutor's last name
	 * 
	 * @param currentEmail: email address of the tutor that we will update his/her
	 *                      last name
	 * @param LastName:     new last name
	 * @exception NullPointerException      if tutor does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateTutorLastName(String currentEmail, String LastName) {
		getTutor(currentEmail).setLast_name(LastName);

	}
	/*------- Get methods -------*/

	/**
	 * this method returns a tutor by giving his/her email
	 * 
	 * @param email: email address of the tutor that will be returned
	 * @return tutor
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public Tutor getTutor(String email) {
		Tutor tutor = tutorRepository.findByEmail(email);
		return tutor;
	}

//	    public List<Tutor> getAllVerifiedTutors() {
//	    	List<Tutor> verifiedTutors = new ArrayList<Tutor>();
//	    	for (int i = 0; i < getAllTutors().size(); i++) {
//	    		if (getAllTutors().get(i).isVerified() ==true) {
//	    			verifiedTutors.add(getAllTutors().get(i));
//	    		}
//	    	}
//		    return verifiedTutors;
//		    }
	/**
	 * this method returns a list of all the tutors in the tutor repository
	 * 
	 * @return list of all tutors
	 */
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}

	/**
	 * this method create a list of type <T>
	 * 
	 * @param <T>
	 * @param iterable
	 * @return a list of type <T>
	 */
	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

	/*------- Assert methods -------*/
	/**
	 * throws an exception if tutor already exists
	 * 
	 * @param email: email address of tutor
	 * @exception EntityExistsException if tutor already exists
	 */
	@Transactional
	public void containsTutor(String email) {
		if (tutorRepository.existsById(email))
			throw new EntityExistsException("Tutor Already Exists");
	}

	/**
	 * throws an exception if tutor does not exist
	 * 
	 * @param : email address of tutor
	 * @exception NullPointerException if tutor does not exist
	 */
	@Transactional
	public void tutorNotExisted(String email) {
		if (tutorRepository.existsById(email) == false)
			throw new NullPointerException("Tutor Does not Exist");
	}

	/**
	 * this method makes sure that the input follows the correct pattern
	 * 
	 * @param FirsName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @return true if in input is not correct, false otherwise
	 */
	private boolean incorrectTutorDetails(String FirsName, String LastName, String Email, String PhoneNumber,
			String Password) {
		if (FirsName == null || FirsName.trim().length() == 0 || LastName == null || LastName.trim().length() == 0
				|| Email == null || Email.trim().length() == 0 || PhoneNumber == null || PhoneNumber == null
				|| Password == null || Password.trim().length() == 0) {
			return true;
		}
		return false;
	}
	/*------------- other methods*************/
//	        
//	        public void verifyTutor(String email) {
//	        	getTutor(email).setVerified(true);;
//	        }

}
