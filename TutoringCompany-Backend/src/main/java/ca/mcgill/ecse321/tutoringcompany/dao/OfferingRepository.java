package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Offering;
//import ca.mcgill.ecse321.tutoringcompany.model.TimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

public interface OfferingRepository extends CrudRepository <Offering, Integer> {

	Offering findById(int id);

	List<Offering> findOfferingByTutor(Tutor tutor);

}