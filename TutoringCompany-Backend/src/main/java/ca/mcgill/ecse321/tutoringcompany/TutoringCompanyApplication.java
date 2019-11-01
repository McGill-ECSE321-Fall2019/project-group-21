package ca.mcgill.ecse321.tutoringcompany;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.StudentReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanySessionService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorTimeBlockService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyOfferingService;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.model.RoomTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorReviewsService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomTimeBlockService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentReviewsService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoringCompanyApplication {
	@Autowired
	private TutoringCompanyStudentService StudentService;
	@Autowired
	private TutoringCompanySessionService SessionService;
	@Autowired
	private TutoringCompanyTutorService TutorService;
	@Autowired
	private TutoringCompanyManagerService ManagerService;
	@Autowired
//	private TutoringCompanyRoomService RoomService;
//	@Autowired
	private TutoringCompanyOfferingService OfferingService;
	@Autowired
	private TutoringCompanyTutorReviewsService TutorReviewsService;
	@Autowired
	private TutoringCompanyTutorTimeBlockService TutorTimeBlockService;
	@Autowired
	private TutoringCompanyRoomTimeBlockService RoomTimeBlockService;
	@Autowired
	private TutoringCompanyRoomService RoomService;
	@Autowired
	private TutoringCompanyStudentReviewsService StudentReviewsService;
	
  public static void main(String[] args) {
    SpringApplication.run(TutoringCompanyApplication.class, args);
  }
  @Autowired
	private TutoringCompanyCourseService CourseService;
//	@Autowired
//	private TutoringCompanyTutorTimeBlockService TutorTimeBlockService;
//	
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
  //@RequestMapping("/room")
//  public List<Room> rooms(){
//    return RoomService.getAllRooms();
//  }
  @RequestMapping("/man")
  public List<Manager> man(){
    return ManagerService.find();
  }
  @RequestMapping("/offering")
  public List<Offering> off(){
    return OfferingService.getAllOfferings();
  }


//  @RequestMapping("/review")
//  public List<TutorReviews> review(){
//    return TutorReviewsService.getAllTutorReviews();
//  }
  
  
  @RequestMapping("/course")
  public List<Course> course(){
    return CourseService.getAllCourses();
  }
  @RequestMapping("/session")
  public List<Session> tb(){
   return SessionService.getAllSessions();
   }
  @RequestMapping("/student")
  public List<Student> st(){
   return StudentService.getAllStudents();
   } 
  @RequestMapping("/tutorTimeBlock")
  public List<TutorTimeBlock> ttb(){
   return TutorTimeBlockService.getAllTutorTimeBlocks();
   }
  
  @RequestMapping("/roomTimeBlock")
  public List<RoomTimeBlock> rtb(){
   return RoomTimeBlockService.getAllRoomTimeBlocks();
   }

@RequestMapping("/room")
public List<Room> room(){
 return RoomService.getAllRooms();
 }
@RequestMapping("/review")
public List<StudentReviews> reviews(){
 return StudentReviewsService.getAllStudentReviews();
 }

//  @RequestMapping("/tt")
//  public boolean tt(){
//   return TutorTimeBlockService.isAvailable(04, 11, 1997, TutorService.getTutor("al7bib"), 8);
 //  }
}

