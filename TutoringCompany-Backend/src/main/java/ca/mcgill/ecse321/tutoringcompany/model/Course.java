package ca.mcgill.ecse321.tutoringcompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private Subject subject;

	public void setSubject(Subject value) {
		this.subject = value;
	}

	public Subject getSubject() {
		return this.subject;
	}

	private String course_id;

	public void setCourse_id(String value) {
		this.course_id = value;
	}

	@Id
	public String getCourse_id() {
		return this.course_id;
	}
}
