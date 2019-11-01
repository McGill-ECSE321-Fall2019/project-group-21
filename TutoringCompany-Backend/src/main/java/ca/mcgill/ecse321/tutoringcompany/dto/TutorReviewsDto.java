package ca.mcgill.ecse321.tutoringcompany.dto;

public class TutorReviewsDto {
	private String body;
	private int stars;
	private int id;
	
	public TutorReviewsDto(String body, int stars, int id) {
		this.body = body;
		this.stars = stars;
		this.id = id;
	}
	
	public String getBody() {
		return body;
	}
	public int getid() {
		return id;
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