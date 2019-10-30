package ca.mcgill.ecse321.tutoringcompany.dto;
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
public class CourseDto {
	
	 public CourseDto(String name, Subject subject, String course_id) {
		super();
		this.name = name;
		this.subject = subject;
		this.course_id = course_id;
	}
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
	 public String getCourse_id() {
	     return this.course_id;
	 }
	 }
