package ca.mcgill.ecse321.tutoringcompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Course{
   private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
private Subject subject;

public void setSubject(Subject value) {
    this.subject = value;
}
public Subject getSubject() {
    return this.subject;
}
private String course_id;

public void setCourse_id(String value) {
    this.course_id = value;
}
@Id
public String getCourse_id() {
    return this.course_id;
}
   private Set<Offering> offering;
   
   @OneToMany(mappedBy="course" )
   public Set<Offering> getOffering() {
      return this.offering;
   }
   
   public void setOffering(Set<Offering> offerings) {
      this.offering = offerings;
   }
   
   }
