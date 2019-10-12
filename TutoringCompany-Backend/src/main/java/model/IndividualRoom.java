package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class IndividualRoom extends Room{
   private Set<String/*No type specified*/> availability;
   
   @OneToMany
   public Set<String/*No type specified*/> getAvailability() {
      return this.availability;
   }
   
   public void setAvailability(Set<String/*No type specified*/> availabilitys) {
      this.availability = availabilitys;
   }
   
   private Set<OneToOneSession> oneToOneSession;
   
   @OneToMany(mappedBy="individualRoom" )
   public Set<OneToOneSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<OneToOneSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   private Set<Availability> availability1;
   
   @OneToMany(mappedBy="individualRoom" )
   public Set<Availability> getAvailability1() {
      return this.availability1;
   }
   
   public void setAvailability1(Set<Availability> availability1s) {
      this.availability1 = availability1s;
   }
   
   }
