package ca.mcgill.ecse321.tutoringcompany.dto;

import javax.persistence.Id;

public class StudentDto {

	public StudentDto(String first_name, String last_name, String email, String phone_number, String password) { // should
																													// this
																													// be
																													// review
																													// or
																													// reviews
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}

	private String first_name;

	public void setFirst_name(String value) {
		this.first_name = value;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	private String password;

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	private String last_name;

	public void setLast_name(String value) {
		this.last_name = value;
	}

	public String getLast_name() {
		return this.last_name;
	}

	private String email;

	public void setEmail(String value) {
		this.email = value;
	}

	@Id
	public String getEmail() {
		return this.email;
	}

	private String phone_number;

	public void setPhone_number(String value) {
		this.phone_number = value;
	}

	public String getPhone_number() {
		return this.phone_number;
	}

}