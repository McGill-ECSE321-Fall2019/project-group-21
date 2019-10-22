package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Room{
   private int number;

public void setNumber(int value) {
    this.number = value;
}
@Id
public int getNumber() {
    return this.number;
}
private Set<TimeBlock> timeBlock;

@OneToMany(mappedBy="room" )
public Set<TimeBlock> getTimeBlock() {
   return this.timeBlock;
}

public void setTimeBlock(Set<TimeBlock> timeBlocks) {
   this.timeBlock = timeBlocks;
}

private RoomType room_type;

public void setRoom_type(RoomType value) {
    this.room_type = value;
}
public RoomType getRoom_type() {
    return this.room_type;
}
   private Set<Session> session;
   
   @OneToMany(mappedBy="room" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   }
