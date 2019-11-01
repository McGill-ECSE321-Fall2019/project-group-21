package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

public interface SessionRepository extends CrudRepository<Session, Integer> {
	Optional<Session> findById(int id);

}