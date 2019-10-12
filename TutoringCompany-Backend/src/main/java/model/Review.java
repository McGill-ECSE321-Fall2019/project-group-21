package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review{
   private String review_text;

public void setReview_text(String value) {
    this.review_text = value;
}
public String getReview_text() {
    return this.review_text;
}
   private Student student;
   
   @ManyToOne(optional=false)
   public Student getStudent() {
      return this.student;
   }
   
   public void setStudent(Student student) {
      this.student = student;
   }
   
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   }
