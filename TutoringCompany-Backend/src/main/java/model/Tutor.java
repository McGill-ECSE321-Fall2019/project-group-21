package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Tutor extends PersonRole{
   private Set<Review> reviews;
   
   @OneToMany(mappedBy="tutor" , cascade={CascadeType.ALL})
   public Set<Review> getReviews() {
      return this.reviews;
   }
   
   public void setReviews(Set<Review> reviewss) {
      this.reviews = reviewss;
   }
   
   private Set<Product> product;
   
   @OneToMany(mappedBy="tutor" )
   public Set<Product> getProduct() {
      return this.product;
   }
   
   public void setProduct(Set<Product> products) {
      this.product = products;
   }
   
   private Set<String/*No type specified*/> availability;
   
   @OneToMany
   public Set<String/*No type specified*/> getAvailability() {
      return this.availability;
   }
   
   public void setAvailability(Set<String/*No type specified*/> availabilitys) {
      this.availability = availabilitys;
   }
   
   private boolean is_approved;

public void setIs_approved(boolean value) {
    this.is_approved = value;
}
public boolean isIs_approved() {
    return this.is_approved;
}
   private Set<OneToOneSession> oneToOneSession;
   
   @OneToMany(mappedBy="tutor" )
   public Set<OneToOneSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<OneToOneSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   private Set<GroupSession> groupSession;
   
   @OneToMany(mappedBy="tutor" )
   public Set<GroupSession> getGroupSession() {
      return this.groupSession;
   }
   
   public void setGroupSession(Set<GroupSession> groupSessions) {
      this.groupSession = groupSessions;
   }
   
   private Set<Review> revew;
   
   @OneToMany(mappedBy="tutor" , cascade={CascadeType.ALL})
   public Set<Review> getRevew() {
      return this.revew;
   }
   
   public void setRevew(Set<Review> revews) {
      this.revew = revews;
   }
   
   private Set<Availability> availability1;
   
   @OneToMany(mappedBy="tutor" )
   public Set<Availability> getAvailability1() {
      return this.availability1;
   }
   
   public void setAvailability1(Set<Availability> availability1s) {
      this.availability1 = availability1s;
   }
   
   }
