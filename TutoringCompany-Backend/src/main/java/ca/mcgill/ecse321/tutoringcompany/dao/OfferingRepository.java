package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Offering;
//import ca.mcgill.ecse321.tutoringcompany.model.TimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

public interface OfferingRepository extends CrudRepository<Offering, Integer> {

	Optional<Offering> findById(int id);

}