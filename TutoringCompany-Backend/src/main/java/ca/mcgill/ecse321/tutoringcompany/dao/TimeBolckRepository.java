//package ca.mcgill.ecse321.tutoringcompany.dao;
//
//
//import org.springframework.data.repository.CrudRepository;
//
//
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
//import ca.mcgill.ecse321.tutoringcompany.model.TimeBlock;
//
//@CrossOrigin(origins = "*")
//public interface TimeBolckRepository extends CrudRepository<TimeBlock, Integer> {
//
//	 TimeBlock findById(@Param(value = "id") int id);
// 
//  TimeBlock save(TimeBlock timeblock);
//}