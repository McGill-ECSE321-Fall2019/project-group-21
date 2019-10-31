package ca.mcgill.ecse321.tutoringcompany.dto;

import java.sql.Date;
import java.sql.Time;

public class SessionDto {
	private Time start_time, end_time;
	private Date date;
	private TutorDto tutorDto;

	public SessionDto(Time start_time, Time end_time, Date date, TutorDto tutorDto) {
		this.start_time = start_time;
		this.end_time = end_time;
		this.date = date;
	}

	public Time getStart_time() {
		return start_time;
	}
	
	public TutorDto getTutorDto() {
		return tutorDto;
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
