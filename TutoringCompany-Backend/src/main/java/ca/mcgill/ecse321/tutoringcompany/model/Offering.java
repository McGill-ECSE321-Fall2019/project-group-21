package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Offering{
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
   
   private Course course;
   
   @ManyToOne(optional=false)
   public Course getCourse() {
      return this.course;
   }
   
   public void setCourse(Course course) {
      this.course = course;
   }
   
   private Set<Session> session;
   
   @OneToMany(mappedBy="offering" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   }
