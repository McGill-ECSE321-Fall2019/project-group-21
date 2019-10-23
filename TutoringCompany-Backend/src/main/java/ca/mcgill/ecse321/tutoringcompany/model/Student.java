package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Student{
   private String first_name;

public void setFirst_name(String value) {
    this.first_name = value;
}

public String getFirst_name() {
    return this.first_name;
}
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
private String last_name;

public void setLast_name(String value) {
    this.last_name = value;
}
public String getLast_name() {
    return this.last_name;
}
private String email;

public void setEmail(String value) {
    this.email = value;
}
@Id
public String getEmail() {
    return this.email;
}
private String phone_number;

public void setPhone_number(String value) {
    this.phone_number = value;
}
public String getPhone_number() {
    return this.phone_number;
}
   private Set<Review> review;
   
   @OneToMany(mappedBy="student" , cascade={CascadeType.ALL})
   public Set<Review> getReview() {
      return this.review;
   }
   
   public void setReview(Set<Review> reviews) {
      this.review = reviews;
   }
   
   private Set<Session> session;
   
   @ManyToMany(mappedBy="student" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   }