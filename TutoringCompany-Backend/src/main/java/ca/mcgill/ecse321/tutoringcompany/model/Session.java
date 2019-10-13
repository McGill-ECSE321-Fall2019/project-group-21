package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;

@Entity
public abstract class Session{
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
}
