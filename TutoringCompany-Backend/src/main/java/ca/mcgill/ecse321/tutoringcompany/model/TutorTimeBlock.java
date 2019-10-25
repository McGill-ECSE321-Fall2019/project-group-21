package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

@Entity
public class TutorTimeBlock{
   private double start_time;

public void setStart_time(double value) {
    this.start_time = value;
}
public double getStart_time() {
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
private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private int day;

public void setDay(int value) {
    this.day = value;
}
public int getDay() {
    return this.day;
}
private int month;

public void setMonth(int value) {
    this.month = value;
}
public int getMonth() {
    return this.month;
}
private int year;

public void setYear(int value) {
    this.year = value;
}
public int getYear() {
    return this.year;
}
}
