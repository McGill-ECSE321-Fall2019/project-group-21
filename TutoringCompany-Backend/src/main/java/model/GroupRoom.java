package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class GroupRoom extends Room{
   private Set<String/*No type specified*/> availability;
   
   @OneToMany
   public Set<String/*No type specified*/> getAvailability() {
      return this.availability;
   }
   
   public void setAvailability(Set<String/*No type specified*/> availabilitys) {
      this.availability = availabilitys;
   }
   
   private Set<GroupSession> groupSession;
   
   @OneToMany(mappedBy="groupRoom" )
   public Set<GroupSession> getGroupSession() {
      return this.groupSession;
   }
   
   public void setGroupSession(Set<GroupSession> groupSessions) {
      this.groupSession = groupSessions;
   }
   
   private Set<Availability> availability1;
   
   @OneToMany(mappedBy="groupRoom" )
   public Set<Availability> getAvailability1() {
      return this.availability1;
   }
   
   public void setAvailability1(Set<Availability> availability1s) {
      this.availability1 = availability1s;
   }
   
   }
