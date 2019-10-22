package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.ManyToMany;

@Entity
public class Session{
   private Date date;

public void setDate(Date value) {
    this.date = value;
}
public Date getDate() {
    return this.date;
}
private Time start_time;

public void setStart_time(Time value) {
    this.start_time = value;
}
public Time getStart_time() {
    return this.start_time;
}
private Time end_time;

public void setEnd_time(Time value) {
    this.end_time = value;
}
public Time getEnd_time() {
    return this.end_time;
}
private int id;

public void setId(int value) {
    this.id = value;
}
@Id
@GeneratedValue()public int getId() {
    return this.id;
}
private SessionType session_type;

public void setSession_type(SessionType value) {
    this.session_type = value;
}
public SessionType getSession_type() {
    return this.session_type;
}
   private Room room;
   
   @ManyToOne(optional=false)
   public Room getRoom() {
      return this.room;
   }
   
   public void setRoom(Room room) {
      this.room = room;
   }
   
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   private Offering offering;
   
   @ManyToOne(optional=false)
   public Offering getOffering() {
      return this.offering;
   }
   
   public void setOffering(Offering offering) {
      this.offering = offering;
   }
   
   private Set<Student> student;
   
   @ManyToMany
   public Set<Student> getStudent() {
      return this.student;
   }
   
   public void setStudent(Set<Student> students) {
      this.student = students;
   }
   
   }
