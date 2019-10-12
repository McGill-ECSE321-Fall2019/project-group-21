package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Person{
   private String first_name;

public void setFirst_name(String value) {
    this.first_name = value;
}
public String getFirst_name() {
    return this.first_name;
}
private PersonRole personRole;

@ManyToOne(optional=false)
public PersonRole getPersonRole() {
   return this.personRole;
}

public void setPersonRole(PersonRole personRole) {
   this.personRole = personRole;
}

private String last_name;

public void setLast_name(String value) {
    this.last_name = value;
}
public String getLast_name() {
    return this.last_name;
}
private String phone;

public void setPhone(String value) {
    this.phone = value;
}
public String getPhone() {
    return this.phone;
}
private String email;

public void setEmail(String value) {
    this.email = value;
}
@Id
public String getEmail() {
    return this.email;
}
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
}
