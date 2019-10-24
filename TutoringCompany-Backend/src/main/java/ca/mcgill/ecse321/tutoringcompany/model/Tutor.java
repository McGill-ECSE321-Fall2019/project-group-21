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
private Set<Review> review;

@OneToMany(mappedBy="tutor1" , cascade={CascadeType.ALL})
public Set<Review> getReview() {
   return this.review;
}

public void setReview(Set<Review> reviews) {
   this.review = reviews;
}

private Set<Offering> offering;

@OneToMany(mappedBy="tutor" )
public Set<Offering> getOffering() {
   return this.offering;
}

public void setOffering(Set<Offering> offerings) {
   this.offering = offerings;
}

private Set<TimeBlock> timeBlock;

@OneToMany(mappedBy="tutor1" )
public Set<TimeBlock> getTimeBlock() {
   return this.timeBlock;
}

public void setTimeBlock(Set<TimeBlock> timeBlocks) {
   this.timeBlock = timeBlocks;
}

private Set<Session> session;

@OneToMany(mappedBy="tutor" )
public Set<Session> getSession() {
   return this.session;
}

public void setSession(Set<Session> sessions) {
   this.session = sessions;
}

private boolean verified=false;

public void setVerified(boolean value) {
    this.verified = value;
}
public boolean isVerified() {
    return this.verified;
}
}
