package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Course{
   private Subject subject;
   
   @ManyToOne(optional=false)
   public Subject getSubject() {
      return this.subject;
   }
   
   public void setSubject(Subject subject) {
      this.subject = subject;
   }
   
   private Set<Product> product;
   
   @OneToMany(mappedBy="course" )
   public Set<Product> getProduct() {
      return this.product;
   }
   
   public void setProduct(Set<Product> products) {
      this.product = products;
   }
   
   private String name;

public void setName(String value) {
    this.name = value;
}
@Id
public String getName() {
    return this.name;
}
}
