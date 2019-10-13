package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Group{
   private Set<Student> student;
   
   @ManyToMany
   public Set<Student> getStudent() {
      return this.student;
   }
   
   public void setStudent(Set<Student> students) {
      this.student = students;
   }
   
   private Set<GroupSession> groupSession;
   
   @OneToMany(mappedBy="group" )
   public Set<GroupSession> getGroupSession() {
      return this.groupSession;
   }
   
   public void setGroupSession(Set<GroupSession> groupSessions) {
      this.groupSession = groupSessions;
   }
   
   }
