package ca.mcgill.ecse321.tutoringcompany.model;

import javax.persistence.Entity;

@Entity
public abstract class Room{
   private int number;

public void setNumber(int value) {
    this.number = value;
}
public int getNumber() {
    return this.number;
}
}
