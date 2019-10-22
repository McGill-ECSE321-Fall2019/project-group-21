package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.TutorRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Student;

@Service
public class TutoringCompanyService {
    
    @Autowired
     StudentRepository studentRepository;
    @Autowired
    TutorRepository tutorRepository;
 
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