package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Review{
   private String body;

public void setBody(String value) {
    this.body = value;
}
public String getBody() {
    return this.body;
}
private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private int id;

public void setId(int value) {
    this.id = value;
}
@GeneratedValue()public int getId() {
    return this.id;
}
private Student student;

@ManyToOne(optional=false)
public Student getStudent() {
   return this.student;
}

public void setStudent(Student student) {
   this.student = student;
}

private int stars;

public void setStars(int value) {
    this.stars = value;
}
public int getStars() {
    return this.stars;
}
}
