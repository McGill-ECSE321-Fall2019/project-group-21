package ca.mcgill.ecse321.tutoringcompany;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringcompany.model.Manager;
import ca.mcgill.ecse321.tutoringcompany.model.Room;
import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyRoomService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyStudentService;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyTutorService;

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
	
  public static void main(String[] args) {
    SpringApplication.run(TutoringCompanyApplication.class, args);
  }

  @RequestMapping("/")
  public List<Student> greeting(){
    return StudentService.getAllStudents();
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




}

