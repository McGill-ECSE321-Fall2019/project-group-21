//package ca.mcgill.ecse321.tutoringcompany.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
//import ca.mcgill.ecse321.tutoringcompany.dao.RoomRepository;
//import ca.mcgill.ecse321.tutoringcompany.model.Manager;
//import ca.mcgill.ecse321.tutoringcompany.model.Room;
//import ca.mcgill.ecse321.tutoringcompany.model.RoomType;
//import ca.mcgill.ecse321.tutoringcompany.model.Student;
///**
// * 
// * @author Elias Tamraz
// *
// */
//@Service
//public class TutoringCompanyRoomService {
//    @Autowired
//    RoomRepository roomRepository;
//  
//
//   @Transactional
//   public Room createRoom(RoomType type) {
//       Room room = new Room();
//       return room;
//   }
// // @Transactional
////   public void deleteManager(String id) {
////   roomRepository.delete(getroom(id));
//   	
//
//   /***
//    * assign to group session  -- @Todo
//    * 
//    * 
//    */
//   
//   /***
//    * make sure correct form information is entered  -- @Todo
//    * 
//    * 
//    */
//   
//   /***
//    * check if email is existed in the database.  -- @Todo
//    * 
//    * 
//    *
//    */
//   
//   @Transactional
//   public Room  getroom(int id) {
//   Room room = roomRepository.findByNumber(id);
//   return room;
//   }
//
//
//   
//   
////   
////   @Transactional
////   public List<Room> getAllRooms() {
////   return toList(roomRepository.findAll());
////   }
////   private <T> List<Room> toList(Iterable<T> iterable){
////   	List<T> resultList = new ArrayList<T>();
////   	for (T t : iterable) {
////   	resultList.add(t);
////   	}
////   	return resultList;
////   	}
//
//   
//
//}
