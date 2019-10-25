package ca.mcgill.ecse321.tutoringcompany;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
//import ca.mcgill.ecse321.tutoringcompany.model.TimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTimeBlockService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;
//import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorTimeBlockService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoringCompanyApplication {
	@Autowired
	private TutoringCompanyStudentService StudentService;
	@Autowired
	private TutoringCompanyTutorService TutorService;
	@Autowired
	private TutoringCompanyManagerService ManagerService;
	@Autowired
	private TutoringCompanyRoomService RoomService;
	@Autowired
	private TutoringCompanyCourseService CourseService;
//	@Autowired
//	private TutoringCompanyTutorTimeBlockService TutorTimeBlockService;
//	
	
  public static void main(String[] args) {
    SpringApplication.run(TutoringCompanyApplication.class, args);
  }

  @RequestMapping("/")
  public String greeting(){
    return "hello world!";
  }
  @RequestMapping("/t")
  public List<Tutor> tutors(){
    return TutorService.getAllTutors();
  }
  @RequestMapping("/m")
  public List<Manager> managers(){
    return ManagerService.getAllManagers();
  }
  @RequestMapping("/room")
  public List<Room> rooms(){
    return RoomService.getAllRooms();
  }
  @RequestMapping("/man")
  public List<Manager> man(){
    return ManagerService.find();
  }
  @RequestMapping("/course")
  public List<Course> course(){
    return CourseService.getAllCourses();
  }
//  @RequestMapping("/tb")
//  public List<TutorTimeBlock> tb(){
//   return TutorTimeBlockService.getAllTimeBlocks();
//   }
//  
//  @RequestMapping("/tt")
//  public boolean tt(){
//   return TutorTimeBlockService.isAvailable(04, 11, 1997, TutorService.getTutor("al7bib"), 8);
 //  }
}

