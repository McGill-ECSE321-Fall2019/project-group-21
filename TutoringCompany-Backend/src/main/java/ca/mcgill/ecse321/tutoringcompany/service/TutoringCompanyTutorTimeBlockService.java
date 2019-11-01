package ca.mcgill.ecse321.tutoringcompany.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.TutorTimeBlockRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;

/**
 *
 * @author George Kandalaft
 *
 */
@Service
public class TutoringCompanyTutorTimeBlockService {

  @Autowired
  TutorTimeBlockRepository tutorTimeBlockRepository;
  @Autowired
  private TutoringCompanyTutorService TutorService;
 
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
  public TutorTimeBlock createTutorTimeBlock(int day, int month, int year, double start_time, String Email) {
      TutorTimeBlock tb = new TutorTimeBlock();
      tb.setDay(day);
      tb.setMonth(month);
      tb.setYear(year);
      tb.setStart_time(start_time);
      tb.setTutor(TutorService.getTutor(Email));
      tutorTimeBlockRepository.save(tb);
      return tb;
  }
  /**
   * delete timeBlock with the specific id
   *
   * @param id of the TimeBlock
   *
   */

  @Transactional
  public void deleteTutorTimeBlock(int day, int month, int year, Tutor t, double start_time) {
 
      tutorTimeBlockRepository.deleteById(findid(day,month,year,t,start_time));
  }
 
  public int findid(int day, int month, int year, Tutor t, double start_time) {
         
      List <TutorTimeBlock> all = getAllTimeBlocks();
      int results =-1;
     
      for (TutorTimeBlock m : all) {
          if(m.getDay()== day && m.getMonth()==month&&m.getYear()==year&&m.getTutor().equals(t)&&m.getStart_time()==start_time) {
              results = m.getId();
              return results;
          }
        
          }
      return results;
      }

  @Transactional
  public List<TutorTimeBlock> getAllTimeBlocks() {
      return (List<TutorTimeBlock>) tutorTimeBlockRepository.findAll();
  }
  @Transactional
  public boolean isAvailable(int day, int month, int year,Tutor t, double time) {
      int id =findid(day,month,year, t, time);
      TutorTimeBlock tb =tutorTimeBlockRepository.findById(id).get();
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
	public List<TutorTimeBlock> getTutorTimeBlocks(Tutor tutor) {
		List<TutorTimeBlock> timeBlockByTutor = new ArrayList<>();
		for (TutorTimeBlock timeBlock : tutorTimeBlockRepository.findAll()) {
			if (timeBlock.getTutor().equals(tutor)) {
				timeBlockByTutor.add(timeBlock);
			}
		}
		return timeBlockByTutor;
	}

 
  public List<Tutor> getAvailableTutors(int day, int month, int year, double time){
      List <Tutor> all = TutorService.getAllTutors();
      ArrayList <Tutor> available = new ArrayList<Tutor>();
      for (Tutor t : all) {
          if (isAvailable(day,month, year, t, time)) {
              available.add(t);
          }
      }
 
      return available;
     
  }
  
  @Transactional
	public List<TutorTimeBlock> getAllTutorTimeBlocks() {
		return (List<TutorTimeBlock>) tutorTimeBlockRepository.findAll();
	}
 
  public List<Tutor> availableFromTo(int day, int month, int year, double from, double duration){
     
      List <Tutor> all = TutorService.getAllTutors();
      ArrayList <Tutor> available = new ArrayList<Tutor>();
      for (Tutor t : all) {
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