package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity
public class Student extends PersonRole{
   private Set<Review> reviews;
   
   @OneToMany(mappedBy="student" )
   public Set<Review> getReviews() {
      return this.reviews;
   }
   
   public void setReviews(Set<Review> reviewss) {
      this.reviews = reviewss;
   }
   
   private Set<Group> group;
   
   @ManyToMany(mappedBy="student" )
   public Set<Group> getGroup() {
      return this.group;
   }
   
   public void setGroup(Set<Group> groups) {
      this.group = groups;
   }
   
   private Set<IndividualSession> oneToOneSession;
   
   @OneToMany(mappedBy="student" )
   public Set<IndividualSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<IndividualSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   private Set<Review> review;
   
   @OneToMany(mappedBy="student" , cascade={CascadeType.ALL})
   public Set<Review> getReview() {
      return this.review;
   }
   
   public void setReview(Set<Review> reviews) {
      this.review = reviews;
   }
   
   }
