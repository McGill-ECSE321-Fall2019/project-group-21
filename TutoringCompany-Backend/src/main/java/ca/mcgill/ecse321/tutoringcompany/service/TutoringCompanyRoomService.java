package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;

/**
 * 
 * @author Elias Tamraz
 * @author Louca Dufault
 *
 */

@Service
public class TutoringCompanyRoomService {
	@Autowired
	RoomRepository roomRepository;

	/**
	 * Create a room instance with the given parameters, save it, and return it
	 * 
	 * @param roomNumber -- @PrimaryKey -- integer that represents the room number //what do these dashes mean
	 * @param type -- one of the RoomType INDIVIDUAL_ROOM or GROUP_ROOM constants
	 * 
	 * @return the created room
	 * 
	 */
	@Transactional
	public Room createRoom(int roomNumber, RoomType roomType) {
		Room room = new Room();
		room.setNumber(roomNumber);
		room.setRoom_type(roomType);
		roomRepository.save(room);
		return room;
	}
	
	/**
	 * Read a specific room by its roomNumber
	 * 
	 * @param roomNumber
	 * 
	 * @exception NullPointerException if room by that roomNumber does not exist
	 * 
	 * @return room
	 */
	@Transactional
	public Room getRoom(int roomNumber) {
		try {
			return roomRepository.findById(roomNumber).get();
		} catch (NoSuchElementException e) {
			throw new NullPointerException("No such Room.");
		}
	}
	
	/**
	 * Read List of Rooms with the given roomType
	 * 
	 * @param roomType
	 * @return List of Rooms with the given roomType
	 */
	@Transactional
	public List<Room> getRooms(RoomType roomType) {
		List<Room> roomsByRoomType = new ArrayList<>();
		for (Room room : roomRepository.findRoomByRoom_type(roomType)) {
			roomsByRoomType.add(room);			
		}
		return roomsByRoomType;
	}
	
	/**
	 * Read List of all Courses in the system
	 * 
	 * @return List of Rooms representing all rooms in the system
	 */
	@Transactional
	public List<Room> getAllRooms() {
		return (List<Room>) roomRepository.findAll();
		//return toList(roomRepository.findAll());
	}
	
	/**
	 * Update the roomType for the specific room passed
	 * 
	 * @param room
	 * @param roomType
	 */
	@Transactional
	public void updateRoom(Room room, RoomType roomType) {
		room.setRoom_type(roomType);
	}
	
	/**
	 * Delete the specific room passed
	 * 
	 * @param room
	 */
	@Transactional
	public void deleteRoom(Room room) {
		roomRepository.delete(room);
	}
	
	/**
	 * Delete a specific room with the given roomNumber
	 * @param roomNumber
	 */
	@Transactional
	public void deleteRoom(int roomNumber) {
		deleteRoom(getRoom(roomNumber));
	}
	
	

//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@Transactional
//	public Room getroom(int id) {
//		Room room = roomRepository.findByNumber(id);
//		return room;
//	}

//	/**
//	 * 
//	 * @param <T>
//	 * @param iterable
//	 * @return
//	 */
//	private <T> List<T> toList(Iterable<T> iterable) {
//		List<T> resultList = new ArrayList<T>();
//		for (T t : iterable) {
//			resultList.add(t);
//		}
//		return resultList;
//	}
}
