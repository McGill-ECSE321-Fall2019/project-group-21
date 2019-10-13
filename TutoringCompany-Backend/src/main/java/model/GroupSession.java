package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GroupSession extends Session{
   private GroupRoom groupRoom;
   
   @ManyToOne(optional=false)
   public GroupRoom getGroupRoom() {
      return this.groupRoom;
   }
   
   public void setGroupRoom(GroupRoom groupRoom) {
      this.groupRoom = groupRoom;
   }
   
   private Group group;
   
   @ManyToOne(optional=false)
   public Group getGroup() {
      return this.group;
   }
   
   public void setGroup(Group group) {
      this.group = group;
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
