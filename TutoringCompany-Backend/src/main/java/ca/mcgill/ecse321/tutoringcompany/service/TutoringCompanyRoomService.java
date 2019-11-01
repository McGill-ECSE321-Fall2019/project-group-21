package ca.mcgill.ecse321.tutoringcompany.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

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
	public Room createRoom(int number, RoomType roomType) {
		roomValid(number);
		roomUnique(number);
		Room room = new Room();
		room.setNumber(number);
		room.setRoom_type(roomType);
		roomRepository.save(room);
		return room;
	}
	
	
	/**
	 * Read a specific room by its roomNumber
	 * 
	 * @param roomNumber
	 * @return room
	 */
	@Transactional
	public Room getRoom(int number) {
		roomExist(number);
		return roomRepository.findById(number).get();
	}
	
	/**
	 * Read List of Rooms with the given roomType
	 * 
	 * @param roomType
	 * @return List of Rooms with the given roomType
	 */
//	@Transactional
//	public List<Room> getRooms(RoomType roomType) {
//		List<Room> roomsByRoomType = new ArrayList<>();
//		for (Room room : roomRepository.findRoomByRoom_type(roomType)) {
//			roomsByRoomType.add(room);			
//		}
//		return roomsByRoomType;
//	}
	
	/**
	 * Read List of all Courses in the system
	 * 
	 * @return List of Rooms representing all rooms in the repository
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
		roomExist(room.getNumber());
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
	
	

	/**
	 * 
	 * @param id
	 * @return
	 */
//	@Transactional
//	public Room getroom(int id) {
//		Room room = roomRepository.findByNumber(id);
//		return room;
//	}

	/**
	 * 
	 * @param <T>
	 * @param iterable
	 * @return
	 */
	private <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
	@Transactional
	public ArrayList<Room> getAllIndividualRooms() {
		List<Room> allRooms= toList(roomRepository.findAll());
		ArrayList<Room> allIndividualRooms= new ArrayList<Room>();
		for (Room room : allRooms) {
			if (room.getRoom_type().equals(RoomType.INDIVIDUAL_ROOM)) {
				allIndividualRooms.add(room);
			}
		}
		return allIndividualRooms;
		
	}

	@Transactional
	public ArrayList<Room> getAllGroupRooms() {
		List<Room> allRooms= toList(roomRepository.findAll());
		ArrayList<Room> allGroupRooms= new ArrayList<Room>();
		for (Room room : allRooms) {
			if (room.getRoom_type().equals(RoomType.GROUP_ROOM)) {
				allGroupRooms.add(room);
			}
		}
		return allGroupRooms;
		
	}
	
	 /**
	  * Ensure that room by the given id is unique or throws exception
	  * 
	  * @param number
	  * @exception EntityExistsException if room already exists
	  */
	 @Transactional
	    public void roomUnique(int number) {
	      if (roomRepository.existsById(number)) {
	        throw new EntityExistsException("room Already Exists");
	    }
	 }
	 
	 /**
	  * Ensures that room by the given id already exists or throws exception
	  * 
	  * @param id
	  * @exception NullPointerException if room does not exist
	  */
	 @Transactional
	    public void roomExist(int id) {
	      if (roomRepository.existsById(id)==false)
	        throw new NullPointerException("room Does not Exist");
	    }
	 
	 /**
	  * Ensures that the room info given is valid or throws exception  
	  * 
	  * @param number
	  * @exception InvalidParameterException if the number is null or negative
	  */
	 @Transactional
	 private void roomValid(int number) {
 	    if ((Integer) number == null || number <= 0) {
 	      throw new InvalidParameterException("Your room details are invalid");
 	    }
 	  }
}


