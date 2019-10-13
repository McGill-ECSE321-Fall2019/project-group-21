package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

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
   
   private Set<OneToOneSession> oneToOneSession;
   
   @OneToMany(mappedBy="product" )
   public Set<OneToOneSession> getOneToOneSession() {
      return this.oneToOneSession;
   }
   
   public void setOneToOneSession(Set<OneToOneSession> oneToOneSessions) {
      this.oneToOneSession = oneToOneSessions;
   }
   
   }
