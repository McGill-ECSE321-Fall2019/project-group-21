package ca.mcgill.ecse321.tutoringcompany.dto;

import java.util.Collections;
import java.util.Set;

import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Review;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.TimeBlock;

public class TutorDto {

	private String first_name, last_name, email, phone_number, password;
	private Set<Review> reviews;
	private Set<Offering> offerings;
	private Set<TimeBlock> timeBlocks;
	private Set<Session> sessions;
	
//	public TutorDto() {
//	}
	
	@SuppressWarnings("unchecked")
	public TutorDto(String first_name, String last_name, String email, String phone_number, String password) {
		this(first_name, last_name, email, phone_number, password, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET);
	}
	

	@SuppressWarnings("unchecked")
	public TutorDto(String first_name, String last_name, String email, String phone_number, String password, Set<Offering> offerings, Set<TimeBlock> timeBlocks) {
		this(first_name, last_name, email, phone_number, password, Collections.EMPTY_SET, offerings, timeBlocks, Collections.EMPTY_SET);
	}

	public TutorDto(String first_name, String last_name, String email, String phone_number, String password, Set<Review> reviews, Set<Offering> offerings, Set<TimeBlock> timeBlocks, Set<Session> sessions) { //should this be review or reviews
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
		this.reviews = reviews;
		this.offerings = offerings;
		this.timeBlocks = timeBlocks;
		this.sessions = sessions;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Offering> getOfferings() {
		return offerings;
	}

	public void setOfferings(Set<Offering> offerings) {
		this.offerings = offerings;
	}

	public Set<TimeBlock> getTimeBlocks() {
		return timeBlocks;
	}

	public void setTimeBlocks(Set<TimeBlock> timeBlocks) {
		this.timeBlocks = timeBlocks;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
}