package ca.mcgill.ecse321.tutoringcompany.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.RoomTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.dao.SessionRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;

/**
 * 
 * @author calebsh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoom {

	@Autowired
	private TutoringCompanyRoomService roomService;

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomTimeBlockRepository roomTimeBlockRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Before
	public void clearDatabase() {
		sessionRepository.deleteAll();
		roomTimeBlockRepository.deleteAll();
		roomRepository.deleteAll();
	}
	
	/**
	 * Create a room
	 * @result Room will be persisted without any errors
	 */
	@Test
	public void testCreateRoom() {
		assertEquals(0, roomService.getAllRooms().size());
		int roomNumber = 123;
		try {
			roomService.createRoom(roomNumber, RoomType.INDIVIDUAL_ROOM);
		} catch (IllegalArgumentException e) {
			fail();
		}
		List<Room> allRooms = roomService.getAllRooms();
		assertEquals(1, allRooms.size());
		//no getRoomNumber()?
		assertEquals(roomNumber, allRooms.get(0).getNumber());
	}
	
	
	//note, it is not trivial to check that an enum value is valid
	/**
	 * Create a room with a null room type
	 * @result Room will not be created due to an error
	 */
	@Test
	public void testCreateRoomNull() {
		assertEquals(0, roomService.getAllRooms().size());
		RoomType roomtype = null;
		String error = null;
		
		try {
			roomService.createRoom(123, roomtype);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your room details are incomplete!", error);
		assertEquals(0, roomService.getAllRooms().size());
	}
	
	/**
	 * Delete a room
	 * @result Room will be deleted without any errors
	 */
	@Test
	public void testDeleteRoom() {
		assertEquals(0, roomService.getAllRooms().size());
		testCreateRoom();
		assertEquals(1, roomService.getAllRooms().size());
		try {
			roomService.deleteRoom(roomService.getRoom(123));
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(0, roomService.getAllRooms().size());
	}
	
	/**
	 * Update a room by changing its room type
	 * @result Room will be updated without any errors
	 */
	@Test
	public void testUpdateRoom() {
		
		assertEquals(0, roomService.getAllRooms().size());
		int number = 123;
		RoomType roomType2 = RoomType.GROUP_ROOM;
		
		try {
			roomService.createRoom(number, RoomType.INDIVIDUAL_ROOM);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		roomService.updateRoom(number, roomType2);
		
		List<Room> allRooms = roomService.getAllRooms();
		Room room = allRooms.get(0);
		
		assertEquals(roomType2, room.getRoom_type());
	}
}