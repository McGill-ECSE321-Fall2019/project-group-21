package ca.mcgill.ecse321.tutoringcompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class RoomTimeBlock {
	private double start_time;

	public void setStart_time(double value) {
		this.start_time = value;
	}

	public double getStart_time() {
		return this.start_time;
	}

	private int id;

	public void setId(int value) {
		this.id = value;
	}

	@Id
	@GeneratedValue()
	public int getId() {
		return this.id;
	}

	private Room room;

	@ManyToOne(optional = false)
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	private int day;

	public void setDay(int value) {
		this.day = value;
	}

	public int getDay() {
		return this.day;
	}

	private int month;

	public void setMonth(int value) {
		this.month = value;
	}

	public int getMonth() {
		return this.month;
	}

	private int year;

	public void setYear(int value) {
		this.year = value;
	}

	public int getYear() {
		return this.year;
	}
}
