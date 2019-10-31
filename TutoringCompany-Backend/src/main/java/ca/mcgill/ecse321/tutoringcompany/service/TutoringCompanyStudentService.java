package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyStudentService {
    
    @Autowired
     StudentRepository studentRepository;
   
    /*------- Creation methods -------*/
/**
 * Create student instance with the given parameters, save it, and return it
 * 
 * @param first_name : first name of the student that will be created
 * @param last_name : last name of the student that will be created
 * @param email    : email address of the student that will be created 
 * @param phone_number : phone number of the student that will be created
 * @param password : password of the student that will be created
 * @return the created student
 * @exception EntityExistsException if the student is existed or the email is used
 * @exception InvalidParameterException if any of the previous parameters equals to null or 
 * the string length equals to zero
 */
    @Transactional
    public Student createStudent(String first_name, String last_name, String email, String phone_number, String password) {
    	studentUnique(email);
    	studentValid(first_name, last_name, email, phone_number, password);
    	Student student = new Student();
       student.setFirst_name(first_name);
       student.setLast_name(last_name);
       student.setEmail(email);
       student.setPhone_number(phone_number);
       student.setPassword(password);
        studentRepository.save(student);
        return student;
    }
    
    /*-------  Delete methods -------*/
    
    /**
     * this method deletes student giving his email address
     * @param Email: email address of the student that will be deleted 
     */
    @Transactional
    public void deleteStudent(String Email) {
    	//studentNotExisted(Email);
    	studentRepository.delete(getStudent(Email));
	}
   
    /*------- Update methods -------*/
    
    /**
     * this method updates the student's all information
     * @param email: email address of the student that we will update his/her information
     * @param first_name: new first name
     * @param last_name: new last name
     * @param phone_number: new phone number
     * @param Password: new password
     * @exception NullPointerException if student does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateStudent(String email, String first_name, String last_name, String phone_number, String Password) {
    	studentExist(email);
    	studentValid(first_name, last_name, email, phone_number, Password);
    	Student student = getStudent(email);
    	student.setFirst_name(first_name);
    	student.setLast_name(last_name);
    	student.setPhone_number(phone_number);
    	student.setPassword(Password);
	}
    
    /**
     * this method updates the student's password
     * @param email: email address of the student that we will update his/her password
     * @param Password: new password
     * @exception NullPointerException if student does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateStudentPassword(String email,String Password) {
    	studentExist(email);
    	if (Password == null || Password.trim().length() == 0) {
    		throw new InvalidParameterException("Your Password input is not correct");
    	}
    	getStudent(email).setPassword(Password);
	}
    
    /**
     * this method updates the student's first name
     * @param email: email address of the student that we will update his/her first name
     * @param FirstName: new first name
     * @exception NullPointerException if student does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateStudentFirstName(String email, String first_name) {
    	 studentExist(email);
    	 if (first_name == null || first_name.trim().length() == 0) {
     		throw new InvalidParameterException("Your first_name input is not correct");
     	}
    	getStudent(email).setFirst_name(first_name);
	}
    
    /**
     * this method updates the student's last name
     * @param email: email address of the student that we will update his/her last name
     * @param last_name: new last name
     * @exception NullPointerException if student does not exist
     * @exception InvalidParameterException if any of the previous parameters equals to null or 
     * the string length equals to zero
     */
    @Transactional
    public void updateStudentLastName(String email, String last_name) {
    	studentExist(email);
    	 if (last_name == null || last_name.trim().length() == 0) {
      		throw new InvalidParameterException("Your first_name input is not correct");
      	}
    	getStudent(email).setLast_name(last_name);
  	
	}
   
    
    /*------- Get methods -------*/

    /**
     * this method returns a student by giving his/her email
     * @param email: email address of the student that will be returned
     * @return student
     * @exception NullPointerException if student does not exist
     */
    @Transactional
    public Student getStudent(String email) { 
    	studentExist(email);
    Student student = studentRepository.findByEmail(email);
    return student;
    }
   
    /**
     * this method returns a list of all the students in the student repository
     * @return list of all students
     */
    @Transactional
    public List<Student> getAllStudents() {
    return toList(studentRepository.findAll());
    }
  
    /**
     * this method create a list of type <T> 
     * @param <T>
     * @param iterable
     * @return a list of type <T>
     */
    private <T> List<T> toList(Iterable<T> iterable){
    	List<T> resultList = new ArrayList<T>();
    	for (T t : iterable) {
    	resultList.add(t);
    	}
    	return resultList;
    	}
    /*------- Assert methods -------*/
    
/**
 * Ensures that student by the given email is unique or throws exception
 * 
 * @param email: email address of student
 * @exception EntityExistsException if student already exists 
 */
    @Transactional
    public void studentUnique(String email) {
      if (studentRepository.existsById(email))
        throw new EntityExistsException("Student Already Exists");
    }
    
    /**
     * Ensures that student by the given email already exists or throws exception
     * 
     * @param : email address of student
     * @exception NullPointerException if student does not exist
     */
    @Transactional
    public void studentExist(String email) {
      if (! studentRepository.existsById(email))
        throw new NullPointerException("Student Does not Exist");
    }
    
   /**
    * Ensures that student info given is valid or throws exception
    * 
    * @param first_name
    * @param last_name
    * @param Email
    * @param phone_number
    * @param Password
    * @exception InvalidParameterException if any of the given parameters are invalid (null or length 0 after trim)
    */
    private void studentValid(String first_name, String last_name, String Email, String phone_number, String Password) {
    	    if (first_name == null || first_name.trim().length() == 0 ||last_name == null || last_name.trim().length() == 0 ||  
    	    		Email == null|| Email.trim().length() == 0 || phone_number == null || phone_number == null ||
    	    				Password ==null   || Password.trim().length() == 0) {
    	    	throw new InvalidParameterException("Your student details are incomplete.");
    	    }
    	  }

}