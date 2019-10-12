package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

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
   
   private Set<OneToOneSession> oneToOneSession;
   
   @OneToMany(mappedBy="student" )
   public Set<OneToOneSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<OneToOneSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   private Set<Review> revew;
   
   @OneToMany(mappedBy="student" )
   public Set<Review> getRevew() {
      return this.revew;
   }
   
   public void setRevew(Set<Review> revews) {
      this.revew = revews;
   }
   
   }
