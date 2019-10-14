package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Person;
import ca.mcgill.ecse321.tutoringcompany.model.PersonRole;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.dao.*;

public class TutoringCompanyService {
    
    @Autowired
     TutorRepository TutorRepository;
    @Autowired
     PersonRepository PersonRepository;
    @Autowired
    ManagerRepository ManagerRepository;
    @Autowired
    CourseRepository CourseRepository;
    
    
  
     /**
       * Method to create a Person
       *
       * @param firstName
       * @param lastName
       * @param phoneNumber
       * @param email
       * @param password
       * @param personRole
       * @return
       */
    @Transactional
      public Person createPerson (String firstName, String lastName, String phoneNumber, String email, String password, PersonRole personRole) {  
        Person p = new Person();
        p.setFirst_name(firstName);
        p.setLast_name(lastName);
        p.setPhone(phoneNumber);
        p.setEmail(email);
        p.setPersonRole(personRole);
        return PersonRepository.save(p);
     
    }
    /*
    public void containsPerson(String mail) {
        if (StudentRepository.existsByEmail(Email))
          throw new EntityExistsException("Person Already Exists");
      }
*/
    /**
     * Method to create a Manager
     *
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param password
     * @return Manager
     */
    @Transactional
    public Manager createManager(String firstName, String lastName, String phoneNumber, String email, String password) {
      
      Manager m = new Manager();
      Person p = createPerson (firstName, lastName, phoneNumber, email, password, m);

      return ManagerRepository.save(m);
    }
    /**
    * Method to create a Tutor
    *
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param password
     * @return Tutor
     *
    */
   @Transactional
   public Tutor createTutor(String firstName, String lastName, String phoneNumber, String email, String password) {
     Tutor t = new Tutor();
     Person p = createPerson (firstName,lastName, phoneNumber, email, password, t);
     return TutorRepository.save(t);
   }
   /**
    * Method to find a Manager by email
    *
    * @param email
    * @return
    */
   
   @Transactional
   public Manager getManager(String email) {
     Manager m = ManagerRepository.findByEmail(email);
     if (m == null)
       throw new EntityNotFoundException("Could not find a Manager with email " + email);
     return m;
   }
  
   /**
    * Method returns in a list all Managers
    *
    * @return
    */
   @Transactional
   public List<Manager> getAllManagers() {
     return toList(ManagerRepository.findAll());
   }


/**
      * Method to find a student by email
      *
      * @param email
      * @return
      */
     @Transactional
     public Student getStudent(String email) {
       Student s = StudentRepository.findByEmail(email);
       if (s == null)
         throw new EntityNotFoundException("Could not find a Student with email " + email);
       return s;
     }
     
     
     private <T> List<T> toList(Iterable<T> iterable) {
    	   List<T> resultList = new ArrayList<T>();
    	   for (T t : iterable) {
    	     resultList.add(t);
    	   }
    	   return resultList;
    	 }
     /**
      * Method to create a Course
      *
      * @param courseName
      * @param subject
      *
      * @return Course
      */
   @Transactional
     public Course createCourse (String courseName, Subject subject) {
       
       Course c = new Course();
       c.setName(courseName);
       c.setSubject(subject);
       return CourseRepository.save(c);
     }
}