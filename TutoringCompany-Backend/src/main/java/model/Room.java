package model;

import javax.persistence.Entity;

@Entity
public abstract class Room{
   private int room_id;

public void setRoom_id(int value) {
    this.room_id = value;
}
public int getRoom_id() {
    return this.room_id;
}
}
