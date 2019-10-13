package model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OneToOneSession extends Session{
   private IndividualRoom individualRoom;
   
   @ManyToOne(optional=false)
   public IndividualRoom getIndividualRoom() {
      return this.individualRoom;
   }
   
   public void setIndividualRoom(IndividualRoom individualRoom) {
      this.individualRoom = individualRoom;
   }
   
   private Student student;
   
   @ManyToOne(optional=false)
   public Student getStudent() {
      return this.student;
   }
   
   public void setStudent(Student student) {
      this.student = student;
   }
   
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   private Product product;
   
   @ManyToOne(optional=false)
   public Product getProduct() {
      return this.product;
   }
   
   public void setProduct(Product product) {
      this.product = product;
   }
   
   }
