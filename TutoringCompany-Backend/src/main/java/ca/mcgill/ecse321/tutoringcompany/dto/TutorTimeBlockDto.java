package ca.mcgill.ecse321.tutoringcompany.dto;

public class TutorTimeBlockDto {
	private double start_time;
	private int day, month, year;
	private TutorDto tutorDto;

	public TutorTimeBlockDto(double start_time, int day, int month, int year, TutorDto tutorDto) {
		this.start_time = start_time;
		this.day = day;
		this.month = month;
		this.year = year;
		this.tutorDto = tutorDto;
	}

	public double getStart_time() {
		return start_time;
	}
	public TutorDto getTutorDto() {
		return tutorDto;
	}

	public void setStart_time(double start_time) {
		this.start_time = start_time;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Wrapper that sets the day, month and year passed as arguments
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public void setDMY(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Wrapper that gets the day, month and year as a 3-item integer array
	 * 
	 * @return array with the day, month, and year
	 */
	public int[] getDMY() {
		return new int[] {day, month, year};
	}
}