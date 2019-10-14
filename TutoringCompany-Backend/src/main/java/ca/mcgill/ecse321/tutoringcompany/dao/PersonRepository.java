package ca.mcgill.ecse321.tutoringcompany.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;

import ca.mcgill.ecse321.tutoringcompany.model.Person;
import ca.mcgill.ecse321.tutoringcompany.model.Student;

@CrossOrigin(origins = "*")
public interface PersonRepository extends CrudRepository<Person, String> {
  Person findByEmail(@Param(value = "email") String email);
  Person findByfFirstName(@Param(value = "name") String name);
 Person findByLastName(@Param(value = "name") String name);
 
 
  Person save(Person person);
}