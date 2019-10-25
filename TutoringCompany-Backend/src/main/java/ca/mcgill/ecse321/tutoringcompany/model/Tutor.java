package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Tutor{
   private String first_name;

public void setFirst_name(String value) {
    this.first_name = value;
}
public String getFirst_name() {
    return this.first_name;
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
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
private boolean verified;

public void setVerified(boolean value) {
    this.verified = value;
}
public boolean isVerified() {
    return this.verified;
}
   private Set<TutorReviews> review;
   
   @OneToMany(mappedBy="tutor" , cascade={CascadeType.ALL})
   public Set<TutorReviews> getReview() {
      return this.review;
   }
   
   public void setReview(Set<TutorReviews> reviews) {
      this.review = reviews;
   }
   
   }
