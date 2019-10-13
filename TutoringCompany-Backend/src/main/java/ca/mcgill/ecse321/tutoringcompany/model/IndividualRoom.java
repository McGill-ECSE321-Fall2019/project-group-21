package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class IndividualRoom extends Room{
   private Set<IndividualSession> oneToOneSession;
   
   @OneToMany(mappedBy="individualRoom" )
   public Set<IndividualSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<IndividualSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   private Set<TimeBlock> reservation;
   
   @OneToMany(mappedBy="individualRoom" )
   public Set<TimeBlock> getReservation() {
      return this.reservation;
   }
   
   public void setReservation(Set<TimeBlock> reservations) {
      this.reservation = reservations;
   }
   
   }
