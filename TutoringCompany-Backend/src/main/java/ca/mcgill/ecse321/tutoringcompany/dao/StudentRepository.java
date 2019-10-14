package ca.mcgill.ecse321.tutoringcompany.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Person;
import ca.mcgill.ecse321.tutoringcompany.model.Student;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface StudentRepository extends CrudRepository<Student, String> {

	 static Student findByEmail(@Param(value = "email") String email) {
		// TODO Auto-generated method stub
		return null;
	}
	 Student findByfFirstName(@Param(value = "name") String name);
	 Student findByLastName(@Param(value = "name") String name);
		

  Iterable<Student> findAll();

 
  Student save(Student student);
}