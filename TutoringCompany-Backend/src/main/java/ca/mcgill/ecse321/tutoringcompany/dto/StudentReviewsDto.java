package ca.mcgill.ecse321.tutoringcompany.dto;

public class StudentReviewsDto {
	private String body;
	private int stars;
	private int id;
	
	public StudentReviewsDto(String body, int stars, int id) {
		this.body = body;
		this.stars = stars;
		this.id = id;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public int getStars() {
		return stars;
	}

	public int getId() {
		return id;
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
}