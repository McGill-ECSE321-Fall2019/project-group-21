package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	Optional<Room> findByNumber(int id);
	
	//List<Room> findRoomByRoom_type(RoomType roomType);
	
}
