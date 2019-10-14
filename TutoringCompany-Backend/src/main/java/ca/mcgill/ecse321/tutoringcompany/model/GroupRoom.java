package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class GroupRoom extends Room{
   private Set<GroupSession> groupSession;
   
   @OneToMany(mappedBy="groupRoom" )
   public Set<GroupSession> getGroupSession() {
      return this.groupSession;
   }
   
   public void setGroupSession(Set<GroupSession> groupSessions) {
      this.groupSession = groupSessions;
   }
   
   private Set<TimeBlock> reservation;
   
   @OneToMany(mappedBy="groupRoom" )
   public Set<TimeBlock> getReservation() {
      return this.reservation;
   }
   
   public void setReservation(Set<TimeBlock> reservations) {
      this.reservation = reservations;
   }
   
   }
