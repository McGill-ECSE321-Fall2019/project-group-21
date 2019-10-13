package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

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
private GroupRoom groupRoom;

@ManyToOne(optional=false)
public GroupRoom getGroupRoom() {
   return this.groupRoom;
}

public void setGroupRoom(GroupRoom groupRoom) {
   this.groupRoom = groupRoom;
}

private IndividualRoom individualRoom;

@ManyToOne(optional=false)
public IndividualRoom getIndividualRoom() {
   return this.individualRoom;
}

public void setIndividualRoom(IndividualRoom individualRoom) {
   this.individualRoom = individualRoom;
}

private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private int id;

public void setId(int value) {
    this.id = value;
}
@GeneratedValue()public int getId() {
    return this.id;
}
}
