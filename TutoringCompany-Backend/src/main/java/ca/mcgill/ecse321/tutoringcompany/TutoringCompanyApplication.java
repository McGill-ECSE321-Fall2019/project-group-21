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
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.model.TutorReviews;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Session;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanySessionService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyOfferingService;
import ca.mcgill.ecse321.tutoringcompany.model.TutorTimeBlock;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyCourseService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorReviewsService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoringCompanyApplication {
	
	@Autowired
	private TutoringCompanyManagerService ManagerService;
	
	@Autowired
	private TutoringCompanyRoomService RoomService;
	
	@Autowired
	private TutoringCompanyTutorService TutorService;

	public static void main(String[] args) {
		SpringApplication.run(TutoringCompanyApplication.class, args);
	}

	@RequestMapping("/")
	public String greeting() {
		return "hello world!";
	}
	@RequestMapping("/m")
	  public List<Manager> managers(){
		ManagerService.createManager("heroku", "kok", "nana@mail.com", "54344412", "pp00ook");
	    return ManagerService.getAllManagers();
	  }
	@RequestMapping("/t")
	  public List<Tutor> tutors(){
	    return TutorService.getAllTutors();
	  }
	@RequestMapping("/r")
	  public List<Room> rooms(){
	    return RoomService.getAllRooms();
	  }

}
