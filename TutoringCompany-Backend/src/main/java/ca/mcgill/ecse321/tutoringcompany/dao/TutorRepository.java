package ca.mcgill.ecse321.tutoringcompany.dao;


import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Person;

import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface TutorRepository extends CrudRepository<Tutor, String> {

	 Tutor findByEmail(@Param(value = "email") String email);
	 Tutor findByfFirstName(@Param(value = "name") String name);
	 Tutor findByLastName(@Param(value = "name") String name);
		

  Iterable<Tutor> findAll();

 
  Tutor save(Tutor tutor);
}