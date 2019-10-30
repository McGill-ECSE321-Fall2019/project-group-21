package ca.mcgill.ecse321.tutoringcompany.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.RoomTimeBlock;


public interface RoomTimeBlockRepository extends CrudRepository<RoomTimeBlock, Integer> { 

}
