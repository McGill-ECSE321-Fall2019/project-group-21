package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public abstract class PersonRole{
   private Set<Person> person;
   
   @OneToMany(mappedBy="personRole" , cascade={CascadeType.ALL})
   public Set<Person> getPerson() {
      return this.person;
   }
   
   public void setPerson(Set<Person> persons) {
      this.person = persons;
   }
   
   }
