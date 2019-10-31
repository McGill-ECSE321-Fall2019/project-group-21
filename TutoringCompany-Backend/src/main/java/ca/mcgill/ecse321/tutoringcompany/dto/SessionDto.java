package ca.mcgill.ecse321.tutoringcompany.dto;

import java.sql.Date;
import java.sql.Time;

public class SessionDto {
	private Time start_time, end_time;
	private Date date;
	private OfferingDto offeringDto;
	private int students_Number;

	public SessionDto(Time start_time, Time end_time, Date date, OfferingDto offeringDto,int students_Number) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.date = date;
		this.offeringDto = offeringDto;
		this.students_Number = students_Number;
	}

	public Time getStart_time() {
		return start_time;
	}

	public OfferingDto getOfferingDto() {
		return offeringDto;
	}
	public int getStudents_Number() {
		return students_Number;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
