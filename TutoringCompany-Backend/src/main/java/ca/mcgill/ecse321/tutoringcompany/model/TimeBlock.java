package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class TimeBlock{
   private String day;

public void setDay(String value) {
    this.day = value;
}
public String getDay() {
    return this.day;
}
private Date date;

public void setDate(Date value) {
    this.date = value;
}
public Date getDate() {
    return this.date;
}
private float start_time;

public void setStart_time(float value) {
    this.start_time = value;
}
public float getStart_time() {
    return this.start_time;
}
private int id;

public void setId(int value) {
    this.id = value;
}
@Id
@GeneratedValue()public int getId() {
    return this.id;
}
   private Tutor tutor1;
   
   @ManyToOne(optional=false)
   public Tutor getTutor1() {
      return this.tutor1;
   }
   
   public void setTutor1(Tutor tutor1) {
      this.tutor1 = tutor1;
   }
   
   private Room room;
   
   @ManyToOne(optional=false)
   public Room getRoom() {
      return this.room;
   }
   
   public void setRoom(Room room) {
      this.room = room;
   }
   
   }
