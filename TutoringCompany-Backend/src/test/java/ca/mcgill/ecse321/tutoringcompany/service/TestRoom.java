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
import ca.mcgill.ecse321.tutoringcompany.dao.StudentRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
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
	private TutoringCompanyRoomService RoomService;

	@Autowired
	private RoomRepository roomRepository;
	
	@Before
	public void clearDatabase() {
		roomRepository.deleteAll();
	}
	
//	/**
//	 * Create a room
//	 * @result Room will be persisted without any errors
//	 */
//	@Test
//	public void testCreateRoom() {
//		assertEquals(0, RoomService.getAllRooms().size());
//		int roomNumber = 123;
//		try {
//			RoomService.createRoom(roomNumber, RoomType.INDIVIDUAL_ROOM);
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		List<Room> allRooms = RoomService.getAllRooms();
//		assertEquals(1, allRooms.size());
//		//no getRoomNumber()?
//		assertEquals(roomNumber, allRooms.get(0).getRoomNumber());
//	}
	
	/**
	 * Create a room with a null room type
	 * @result Room will not be created due to an error
	 */
	@Test
	public void testCreateRoomNull() {
		assertEquals(0, RoomService.getAllRooms().size());
		RoomType roomtype = null;
		String error = null;
		try {
			RoomService.createRoom(123, roomtype);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Your room details are incomplete!", error);
		assertEquals(0, RoomService.getAllRooms().size());
	}
	
//	/**
//	 * Delete a room
//	 * @result Room will be deleted without any errors
//	 */
//	@Test
//	public void testDeleteRoom() {
//		assertEquals(0, RoomService.getAllRooms().size());
//		testCreateRoom();
//		assertEquals(1, RoomService.getAllRooms().size());
//		try {
//			RoomService.deleteRoom(RoomService.getRoom(123));
//		} catch (IllegalArgumentException e) {
//			fail();
//		}
//		assertEquals(0, RoomService.getAllRooms().size());
//	}
	
	/**
	 * Update a room
	 * @result Room will be updated without any errors
	 */
	@Test
	public void testUpdateStudent() {
		
		assertEquals(0, RoomService.getAllRooms().size());
		
		RoomType roomType1 = RoomType.INDIVIDUAL_ROOM;
		RoomType roomType2 = RoomType.GROUP_ROOM;
		
		try {
			RoomService.createRoom(123,roomType1);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		RoomService.updateRoom(RoomService.getRoom(123), roomType2);
		
		List<Room> allRooms = RoomService.getAllRooms();
		Room room = allRooms.get(0);
		
		assertEquals(roomType2, room.getRoom_type());
	}
}