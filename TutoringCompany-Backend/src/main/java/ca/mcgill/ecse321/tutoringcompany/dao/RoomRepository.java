package ca.mcgill.ecse321.tutoringcompany.dao;


import org.springframework.data.repository.CrudRepository;


import ca.mcgill.ecse321.tutoringcompany.model.Room;




public interface RoomRepository extends CrudRepository<Room, Integer> {
	Room findByNumber(int id);
	
}
