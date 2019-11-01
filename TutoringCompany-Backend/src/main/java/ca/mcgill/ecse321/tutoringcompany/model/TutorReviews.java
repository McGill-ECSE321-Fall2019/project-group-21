package ca.mcgill.ecse321.tutoringcompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class TutorReviews {
	private String body;

	public void setBody(String value) {
		this.body = value;
	}

	public String getBody() {
		return this.body;
	}

	private int id;

	public void setId(int value) {
		this.id = value;
	}

	@Id
	@GeneratedValue()
	public int getId() {
		return this.id;
	}

	private int stars;

	public void setStars(int value) {
		this.stars = value;
	}

	public int getStars() {
		return this.stars;
	}

	private Tutor tutor;

	@ManyToOne(optional = false)
	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}
