package ca.mcgill.ecse321.tutoringcompany.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface TutorRepository extends CrudRepository<Tutor, String> {

	Tutor findByEmail(String email);
}