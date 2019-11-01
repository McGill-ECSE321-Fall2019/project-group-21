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
	 * this method creates a new student and save it in the student repository
	 * 
	 * @param FirsName    : first name of the student that will be created
	 * @param LastName    : last name of the student that will be created
	 * @param Email       : email address of the student that will be created
	 * @param PhoneNumber : phone number of the student that will be created
	 * @param Password    : password of the student that will be created
	 * @return the created student
	 * @exception EntityExistsException     if the student is existed or the email
	 *                                      is used
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public Student createStudent(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
		containsStudent(Email);
		if (incorrectStudentDetails(FirsName, LastName, Email, PhoneNumber, Password)) {
			throw new InvalidParameterException("Your student details are incomplete!");
		}
		Student student = new Student();
		student.setFirst_name(FirsName);
		student.setLast_name(LastName);
		student.setEmail(Email);
		student.setPhone_number(PhoneNumber);
		student.setPassword(Password);
		studentRepository.save(student);
		return student;
	}
	/*-------  Delete methods -------*/

	/**
	 * this method deletes student giving his email address
	 * 
	 * @param Email: email address of the student that will be deleted
	 * @exception NullPointerException if student does not exist
	 */
	@Transactional
	public void deleteStudent(String Email) {
		studentNotExisted(Email);
		studentRepository.delete(getstudent(Email));
	}

	/*------- Update methods -------*/

	/**
	 * this method updates the student's all information
	 * 
	 * @param currentEmail: email address of the student that we will update his/her
	 *                      information
	 * @param FirsName:     new first name
	 * @param LastName:     new last name
	 * @param PhoneNumber:  new phone number
	 * @param Password:     new password
	 * @exception NullPointerException      if student does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateStudent(String currentEmail, String FirsName, String LastName, String PhoneNumber,
			String Password) {
		studentNotExisted(currentEmail);
		if (incorrectStudentDetails(FirsName, LastName, currentEmail, PhoneNumber, Password)) {
			throw new InvalidParameterException("Your student details are incomplete!");
		}
		getstudent(currentEmail).setFirst_name(FirsName);
		getstudent(currentEmail).setLast_name(LastName);
		getstudent(currentEmail).setPhone_number(PhoneNumber);
		getstudent(currentEmail).setPassword(Password);
		studentRepository.save(getstudent(currentEmail));

	}

	/**
	 * this method updates the student's password
	 * 
	 * @param currentEmail: email address of the student that we will update his/her
	 *                      password
	 * @param Password:     new password
	 * @exception NullPointerException      if student does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateStudentPassword(String currentEmail, String Password) {
		studentNotExisted(currentEmail);
		if (Password == null || Password.trim().length() == 0) {
			throw new InvalidParameterException("Your Password input is not correct");
		}
		getstudent(currentEmail).setPassword(Password);
		studentRepository.save(getstudent(currentEmail));
	}

	/**
	 * this method updates the student's first name
	 * 
	 * @param currentEmail: email address of the student that we will update his/her
	 *                      first name
	 * @param FirstName:    new first name
	 * @exception NullPointerException      if student does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateStudentFirstName(String currentEmail, String FirsName) {
		studentNotExisted(currentEmail);
		if (FirsName == null || FirsName.trim().length() == 0) {
			throw new InvalidParameterException("Your FirsName input is not correct");
		}
		getstudent(currentEmail).setFirst_name(FirsName);
		studentRepository.save(getstudent(currentEmail));
	}

	/**
	 * this method updates the student's last name
	 * 
	 * @param currentEmail: email address of the student that we will update his/her
	 *                      last name
	 * @param LastName:     new last name
	 * @exception NullPointerException      if student does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@Transactional
	public void updateStudentLastName(String currentEmail, String LastName) {
		studentNotExisted(currentEmail);
		if (LastName == null || LastName.trim().length() == 0) {
			throw new InvalidParameterException("Your FirsName input is not correct");
		}
		getstudent(currentEmail).setLast_name(LastName);
		studentRepository.save(getstudent(currentEmail));

	}

	/*------- Get methods -------*/

	/**
	 * this method returns a student by giving his/her email
	 * 
	 * @param email: email address of the student that will be returned
	 * @return student
	 * @exception NullPointerException if student does not exist
	 */
	@Transactional
	public Student getstudent(String email) {
		// studentNotExisted(email);
		Student student = studentRepository.findByEmail(email);
		return student;
	}

	/**
	 * this method returns a list of all the students in the student repository
	 * 
	 * @return list of all students
	 */
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentRepository.findAll());
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
	 * throws an exception if student already exists
	 * 
	 * @param email: email address of student
	 * @exception EntityExistsException if student already exists
	 */
	@Transactional
	public void containsStudent(String email) {
		if (studentRepository.existsById(email))
			throw new EntityExistsException("Student Already Exists");
	}

	/**
	 * throws an exception if student does not exist
	 * 
	 * @param : email address of student
	 * @exception NullPointerException if student does not exist
	 */
	@Transactional
	public void studentNotExisted(String email) {
		if (studentRepository.existsById(email) == false)
			throw new NullPointerException("Student Does not Exist");
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
	private boolean incorrectStudentDetails(String FirsName, String LastName, String Email, String PhoneNumber,
			String Password) {
		if (FirsName == null || FirsName.trim().length() == 0 || LastName == null || LastName.trim().length() == 0
				|| Email == null || Email.trim().length() == 0 || PhoneNumber == null || PhoneNumber == null
				|| Password == null || Password.trim().length() == 0) {
			return true;
		}
		return false;
	}

	@Transactional
	public void studentExist(String email) {
		if (!studentRepository.existsById(email))
			throw new NullPointerException("Student Does not Exist");
	}

}