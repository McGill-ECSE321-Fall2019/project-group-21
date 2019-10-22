//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//import org.springframework.data.repository.CrudRepository;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Manager;
//import ca.mcgill.ecse321.tutoringcompany.model.Person;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin(origins = "*")
//public interface ManagerRepository extends CrudRepository<Manager, String> {
//
//	 Manager findByEmail(@Param(value = "email") String email);
//	
//		
//
//  Iterable<Manager> findAll();
//
// 
//  Manager save(Manager manager);
//}