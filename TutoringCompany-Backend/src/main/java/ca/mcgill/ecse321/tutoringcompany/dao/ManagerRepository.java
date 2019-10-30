package ca.mcgill.ecse321.tutoringcompany.dao;
import org.springframework.data.repository.CrudRepository;


import ca.mcgill.ecse321.tutoringcompany.model.Manager;



public interface ManagerRepository extends CrudRepository<Manager, String> {

	Manager findByEmail(String email);

}