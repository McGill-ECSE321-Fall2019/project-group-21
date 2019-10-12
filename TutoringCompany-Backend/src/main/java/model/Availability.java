package model;

import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.ManyToOne;

@Entity
public class Availability{
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
private int period_of30min;

public void setPeriod_of30min(int value) {
    this.period_of30min = value;
}
public int getPeriod_of30min() {
    return this.period_of30min;
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
   
   }
