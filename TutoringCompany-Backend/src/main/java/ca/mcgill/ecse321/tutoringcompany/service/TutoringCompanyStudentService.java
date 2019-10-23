package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
/**
 * 
 * @author Elias Tamraz
 *
 */
@Service
public class TutoringCompanyStudentService {
    
    @Autowired
     StudentRepository studentRepository;
   
 
    @Transactional
    public Student createStudent(String FirsName, String LastName, String Email, String PhoneNumber, String Password) {
        Student student = new Student();
       
       student.setFirst_name(FirsName);
       student.setLast_name(LastName);
       student.setEmail(Email);
       student.setPhone_number(PhoneNumber);
       student.setPassword(Password);
        studentRepository.save(student);
        return student;
    }
    @Transactional
    public void deleteStudent(String Email) {
    	studentRepository.delete(getstudent(Email));
    	
	}
    @Transactional
    public void updateStudent(String currentEmail, String FirsName, String LastName, String PhoneNumber, String Password) {
    	getstudent(currentEmail).setFirst_name(FirsName);
    	getstudent(currentEmail).setLast_name(LastName);
    	getstudent(currentEmail).setPhone_number(PhoneNumber);
    	getstudent(currentEmail).setPassword(Password);
    	
	}
    @Transactional
    public void updateStudentPassword(String currentEmail,String Password) {
    	getstudent(currentEmail).setPassword(Password);
    	
	}
    @Transactional
    public void updateStudentFirstName(String currentEmail, String FirsName) {
    	getstudent(currentEmail).setFirst_name(FirsName);
  	
	}
    @Transactional
    public void updateStudentLastName(String currentEmail, String LastName) {
    	getstudent(currentEmail).setLast_name(LastName);
  	
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
    public Student getstudent(String email) {
    Student student = studentRepository.findByEmail(email);
    return student;
    }
   
    
    
    
    @Transactional
    public List<Student> getAllStudents() {
    return toList(studentRepository.findAll());
    }
    private <T> List<T> toList(Iterable<T> iterable){
    	List<T> resultList = new ArrayList<T>();
    	for (T t : iterable) {
    	resultList.add(t);
    	}
    	return resultList;
    	}

    
   

}