//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Group;
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
//@CrossOrigin(origins = "*")
//public interface GroupRepository extends CrudRepository<Group, String> {
//
//	 Group findById(@Param(value = "id") int id);
//	
//		
//
//  Iterable<Group> findAll();
//
// 
//  Group save(Group group);
//}