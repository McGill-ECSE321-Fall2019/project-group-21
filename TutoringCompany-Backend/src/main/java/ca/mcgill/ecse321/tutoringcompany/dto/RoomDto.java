package ca.mcgill.ecse321.tutoringcompany.dto;

import java.util.Collections;
import java.util.Set;

import ca.mcgill.ecse321.tutoringcompany.model.RoomTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Session;

public class RoomDto {

	private int number;
	private RoomType roomType;

//	@SuppressWarnings("unchecked")
//	public RoomDto(int number, RoomType roomType) {
//		this(number, roomType, Collections.EMPTY_SET, Collections.EMPTY_SET);
//	}

	public RoomDto(int number, RoomType roomType) {// Set<RoomTimeBlock> roomTimeBlock, Set<Session> sessions) {
		this.number = number;
		this.roomType = roomType;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}