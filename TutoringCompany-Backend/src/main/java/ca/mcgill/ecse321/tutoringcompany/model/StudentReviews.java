package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class StudentReviews{
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
@GeneratedValue()public int getId() {
    return this.id;
}
private int stars;

public void setStars(int value) {
    this.stars = value;
}
public int getStars() {
    return this.stars;
}
   private Student student;
   
   @ManyToOne(optional=false)
   public Student getStudent() {
      return this.student;
   }
   
   public void setStudent(Student student) {
      this.student = student;
   }
   
   }

