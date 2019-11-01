package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Room;

import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;

public interface TutorTimeBlockRepository extends CrudRepository<TutorTimeBlock, Integer> {

//	TutorTimeBlock findByTutorAndStart_time(Tutor t, double start_time);
}