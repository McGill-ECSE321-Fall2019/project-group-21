package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
public class Product{
   private Course course;
   
   @ManyToOne(optional=false)
   public Course getCourse() {
      return this.course;
   }
   
   public void setCourse(Course course) {
      this.course = course;
   }
   
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   private int price_individual;

public void setPrice_individual(int value) {
    this.price_individual = value;
}
public int getPrice_individual() {
    return this.price_individual;
}
private int price_group;

public void setPrice_group(int value) {
    this.price_group = value;
}
public int getPrice_group() {
    return this.price_group;
}
private Set<GroupSession> groupSession;

@OneToMany(mappedBy="product" )
public Set<GroupSession> getGroupSession() {
   return this.groupSession;
}

public void setGroupSession(Set<GroupSession> groupSessions) {
   this.groupSession = groupSessions;
}

private Set<IndividualSession> oneToOneSession;

@OneToMany(mappedBy="product" )
public Set<IndividualSession> getOneToOneSession() {
   return this.oneToOneSession;
}

public void setOneToOneSession(Set<IndividualSession> oneToOneSessions) {
   this.oneToOneSession = oneToOneSessions;
}

private int id;

public void setId(int value) {
    this.id = value;
}
@GeneratedValue()public int getId() {
    return this.id;
}
}
