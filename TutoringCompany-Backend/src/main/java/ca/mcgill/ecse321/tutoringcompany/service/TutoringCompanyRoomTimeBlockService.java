package ca.mcgill.ecse321.tutoringcompany.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.RoomTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.RoomTimeBlock;

/**
 *
 * @author George Kandalaft
 *
 */
@Service
public class TutoringCompanyRoomTimeBlockService {

  @Autowired
  RoomTimeBlockRepository roomTimeBlockRepository;
  @Autowired
  private TutoringCompanyRoomService RoomService;
 
  /**
   * Create Tutor's TimeBlock
   *
   * @param starTime The start time of the TimeBlock.
   * @param tutor    The owner of the TimeBlock.
   * @param date     The date of the TimeBlock.
   *
   * @return The TimeBlock.
   */
  @Transactional
  public RoomTimeBlock createRoomTimeBlock(int day, int month, int year, double start_time, int id) {
      RoomTimeBlock tb = new RoomTimeBlock();
      tb.setDay(day);
      tb.setMonth(month);
      tb.setYear(year);
      tb.setStart_time(start_time);
      tb.setRoom(RoomService.getRoom(id));
      roomTimeBlockRepository.save(tb);
      return tb;
  }
  /**
   * delete timeBlock with the specific id
   *
   * @param id of the TimeBlock
   *
   */

  @Transactional
  public void deleteRoomTimeBlock(int day, int month, int year, Room r, double start_time) {
 
      roomTimeBlockRepository.deleteById(findid(day,month,year,r,start_time));
  }
 
  public int findid(int day, int month, int year, Room r, double start_time) {
         
      List <RoomTimeBlock> all = getAllTimeBlocks();
      int results =-1;
     
      for (RoomTimeBlock m : all) {
          if(m.getDay()== day && m.getMonth()==month&&m.getYear()==year&&m.getRoom().equals(r)&&m.getStart_time()==start_time) {
              results = m.getId();
              return results;
          }
        
          }
      return results;
      }

  @Transactional
  public List<RoomTimeBlock> getAllTimeBlocks() {
      return (List<RoomTimeBlock>) roomTimeBlockRepository.findAll();
  }
  @Transactional
  public boolean isAvailable(int day, int month, int year,Room r, double time) {
      int id =findid(day,month,year, r, time);
      RoomTimeBlock tb =roomTimeBlockRepository.findById(id).get();
      if (tb!= null) {
          return true;
      }
      else {
          return false;
      }
  }
  
  /**
	 * get timeBlocks of a specific tutor
	 *
	 * @param tutor
	 * 
	 * @return the timeblocks
	 */
	public List<RoomTimeBlock> getRoomTimeBlocks(Room room) {
		List<RoomTimeBlock> timeBlockByRoom = new ArrayList<>();
		for (RoomTimeBlock timeBlock : roomTimeBlockRepository.findAll()) {
			if (timeBlock.getRoom().equals(room)) {
				timeBlockByRoom.add(timeBlock);
			}
		}
		return timeBlockByRoom;
	}

 
  public List<Room> getAvailableRooms(int day, int month, int year, double time){
      List <Room> all = RoomService.getAllRooms();
      ArrayList <Room> available = new ArrayList<Room>();
      for (Room t : all) {
          if (isAvailable(day,month, year, t, time)) {
              available.add(t);
          }
      }
 
      return available;
     
  }
  
  @Transactional
	public List<RoomTimeBlock> getAllRoomTimeBlocks() {
		return (List<RoomTimeBlock>) roomTimeBlockRepository.findAll();
	}
 
  public List<Room> availableFromTo(int day, int month, int year, double from, double duration){
     
      List <Room> all = RoomService.getAllRooms();
      ArrayList <Room> available = new ArrayList<Room>();
      for (Room t : all) {
          double i=from;
          double blocksnum=(duration/0.5) -1;
          int check =0;
          for(i=from; i<=from+0.5*blocksnum; i+=0.5) {
              if (isAvailable(day,month, year, t, from)) {
                  check++;
              }
          }
          if (check==duration/0.5) {
              available.add(t);
          }
          check=0;
      }
      return available;
     
  }


}