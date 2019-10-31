package ca.mcgill.ecse321.tutoringcompany.dto;

public class StudentReviewsDto {
	private String body;
	private int stars;
	
	public StudentReviewsDto(String body, int stars) {
		this.body = body;
		this.stars = stars;
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
	
	public void setStars(int stars) {
		this.stars = stars;
	}
}
