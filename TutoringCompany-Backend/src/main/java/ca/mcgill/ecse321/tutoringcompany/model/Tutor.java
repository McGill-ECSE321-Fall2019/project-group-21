package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Tutor extends PersonRole{
   private Set<Product> product;
   
   @OneToMany(mappedBy="tutor" )
   public Set<Product> getProduct() {
      return this.product;
   }
   
   public void setProduct(Set<Product> products) {
      this.product = products;
   }
   
   private boolean is_approved;

public void setIs_approved(boolean value) {
    this.is_approved = value;
}
public boolean isIs_approved() {
    return this.is_approved;
}
   private Set<Review> review;
   
   @OneToMany(mappedBy="tutor" , cascade={CascadeType.ALL})
   public Set<Review> getReview() {
      return this.review;
   }
   
   public void setReview(Set<Review> reviews) {
      this.review = reviews;
   }
   
   private Set<TimeBlock> availability;
   
   @OneToMany(mappedBy="tutor" )
   public Set<TimeBlock> getAvailability() {
      return this.availability;
   }
   
   public void setAvailability(Set<TimeBlock> availabilitys) {
      this.availability = availabilitys;
   }
   
   private Set<IndividualSession> individualSession;
   
   @OneToMany(mappedBy="tutor" )
   public Set<IndividualSession> getIndividualSession() {
      return this.individualSession;
   }
   
   public void setIndividualSession(Set<IndividualSession> individualSessions) {
      this.individualSession = individualSessions;
   }
   
   private Set<GroupSession> groupSession;
   
   @OneToMany(mappedBy="tutor" )
   public Set<GroupSession> getGroupSession() {
      return this.groupSession;
   }
   
   public void setGroupSession(Set<GroupSession> groupSessions) {
      this.groupSession = groupSessions;
   }
   
   }
