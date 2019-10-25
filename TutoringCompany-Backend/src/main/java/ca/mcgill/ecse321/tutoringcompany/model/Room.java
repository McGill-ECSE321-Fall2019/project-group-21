package ca.mcgill.ecse321.tutoringcompany.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room{
   private int number;

public void setNumber(int value) {
    this.number = value;
}
@Id
public int getNumber() {
    return this.number;
}
private RoomType room_type;

public void setRoom_type(RoomType value) {
    this.room_type = value;
}
public RoomType getRoom_type() {
    return this.room_type;
}
}
