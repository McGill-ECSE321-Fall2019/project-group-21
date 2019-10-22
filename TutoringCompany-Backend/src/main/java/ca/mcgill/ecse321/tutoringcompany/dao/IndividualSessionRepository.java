//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//import org.springframework.data.repository.CrudRepository;
//
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import ca.mcgill.ecse321.tutoringcompany.model.IndividualSession;
//
//@CrossOrigin(origins = "*")
//public interface IndividualSessionRepository extends CrudRepository<IndividualSession, String> {
//
//	IndividualSession findByid(@Param(value = "id") int id);
//	
//		
//
//  Iterable<IndividualSession> findAll();
//
// 
//  IndividualSession save(IndividualSession individualSession);
//}