package ca.mcgill.ecse321.tutoringcompany.controller;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.tutoringcompany.dao.*;
import ca.mcgill.ecse321.tutoringcompany.dto.*;
import ca.mcgill.ecse321.tutoringcompany.model.*;
import ca.mcgill.ecse321.tutoringcompany.service.*;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyManagerService;

/**
 * 
 * @author Elias Tamraz
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class TutoringCompanyRestController {
	@Autowired
	TutoringCompanyManagerService managerService;
	@Autowired
	TutoringCompanyTutorService tutorService;
	@Autowired
	TutoringCompanyTutorReviewsService tutorReviewsService;
	@Autowired
	TutoringCompanyRoomService RoomService;
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	TutoringCompanySessionService SessionService;
	@Autowired
	TutoringCompanyOfferingService OfferingService;
	@Autowired
	TutoringCompanyCourseService CourseService;
	@Autowired
	TutoringCompanyStudentService StudentService;

	boolean ManagerLoggedin = false;

	/****************** Login-logout Controllers ***************/
	/**
	 * This method allows a manager to login in order to allow him to use the
	 * methods that follows the path /Manager/...
	 * 
	 * @param ManagerEmail
	 * @param ManagerPassword
	 * @return true to the boolean Manager logged in
	 * @exception NullPointerException      if the manager email is not registered
	 *                                      on the system
	 * @exception InvalidParameterException if the passowrd is incorrect
	 */
	@PostMapping(value = { "/Manager/Login", "/Manager/Login/" })
	public String ManagerLogin(@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		ManagerLoggedin = true;
		return "Welcome you're logged in sucessfully";
	}

	/**
	 * @return false to the boolean ManagerLoggedin
	 * @exception InvalidParameterException the manager is not logged in
	 */
	@PostMapping(value = { "/Manager/Logout", "/Manager/Logout/" })
	public String ManagerLogout() {

		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ManagerLoggedin = false;
		return "you have logged out successfully";
	}

	/****************** Room Services Controllers *********************/

	/**
	 * This method allows the manager to creates a room by passing the roomNumber
	 * integer and the a boolean that differentiates between group room and
	 * individual room
	 * 
	 * @param number integer represents the room id
	 * @param type   Enum RoomType
	 * @return the created roomdto
	 * @exception IllegalArgumentException  if any of the inputs is invalid
	 * @exception EntityExistsException     if there exists a room with the same
	 *                                      room number
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/Create/Room", "/Manager/Create/Room/" })
	public RoomDto CreatRoom(@RequestParam(name = "roomNumber") int number,
			@RequestParam(name = "RoomTypeIsGroup") boolean type) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		RoomType roomType;
		if (type) {
			roomType = RoomType.GROUP_ROOM;
		} else {
			roomType = RoomType.INDIVIDUAL_ROOM;
		}
		Room room = RoomService.createRoom(number, roomType);
		return convertToDto(room);
	}

	/**
	 * This method allows the manager to get all rooms in the database
	 * 
	 * @return list of RoomDto
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@RequestMapping(value = { "/Manager/get/allRooms", "/Manager/get/allRooms/" })
	public List<RoomDto> getAllRooms() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		return convertToRoomListDto(RoomService.getAllRooms());
	}

	/**
	 * This method allows the manager to get all rooms by their type
	 * 
	 * @param isGroup boolean that differentiates between individual room and group
	 *                room
	 * @return list of RoomDto
	 * @throws IllegalArgumentException if @param isGroup was not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/get/RoomByType", "/Manager/get/RoomByType/" })
	public List<RoomDto> getRoomsByType(@RequestParam(name = "isGroupRoom") boolean isGroup)
			throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		if (isGroup) {
			return convertToRoomListDto(RoomService.getAllGroupRooms());
		} else {
			return convertToRoomListDto(RoomService.getAllIndividualRooms());
		}
	}

	/**
	 * This methods allows the manager to delete a room by entering its number
	 * 
	 * @param RoomNumber
	 * @exception IllegalArgumentException  if the RoomNumber is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/delete/Room", "/Manager/delete/room/" })
	public void deleteRoom(@RequestParam(name = "RoomNumber") int RoomNumber) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		RoomService.deleteRoom(RoomNumber);
	}

	/**
	 * This method allows the manager to change the room type from individual to
	 * group or from group to individual by entering the RoomNumber
	 * 
	 * @param RoomNumber int
	 * @return RoomDto that shows the room that its type has been changed
	 * @exception IllegalArgumentException  if RoomNumber is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/update/Room", "/Manager/update/Room/" })
	public RoomDto changeRoomType(@RequestParam(name = "RoomNumber") int RoomNumber) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		RoomType roomType;
		if (RoomService.getRoom(RoomNumber).getRoom_type().equals(RoomType.GROUP_ROOM)) {
			roomType = RoomType.INDIVIDUAL_ROOM;
		} else {
			roomType = RoomType.GROUP_ROOM;
		}
		RoomService.getRoom(RoomNumber).setRoom_type(roomType);
		return convertToDto(RoomService.getRoom(RoomNumber));
	}

	/**
	 * This method allows the manager to get a room by entering its number
	 * 
	 * @param RoomNumber int
	 * @return RoomDto
	 * @exception IllegalArgumentException  if the RoomNumber is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/get/Room", "/Manager/get/Room/" })
	public RoomDto getRoom(@RequestParam(name = "RoomNumber") int RoomNumber) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		Room room = RoomService.getRoom(RoomNumber);
		return convertToDto(room);
	}

	/****************** Manager Services Controllers *********************/

	/**
	 * This method creates a new manager ***Important Note*** This method does not
	 * require a manager to login temporarily because the database is not stable but
	 * eventually will have when the data base is finally set with the default
	 * manager
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @return the created manager
	 * @exception EntityExistsException     if the manager is existed or the email
	 *                                      is used
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero
	 */
	@PostMapping(value = { "/Manager/Create", "/Manager/Create/" })
	public ManagerDto createManager(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName, @RequestParam(name = "email") String Email,
			@RequestParam(name = "phonenumber") String PhoneNumber, @RequestParam(name = "password") String Password)
			throws IllegalArgumentException {
		Manager manager = managerService.createManager(FirstName, LastName, Email, PhoneNumber, Password);
		return convertToDto(manager);
	}

	/**
	 * This method can only be executed by an existing Manager to delete a manager
	 * 
	 * @param Email: email of the manager that will be deleted
	 * @exception InvalidParameterException if Email == null or the length of the
	 *                                      String email ==0
	 * @exception NullPointerException      if the email of the manager that will be
	 *                                      deleted does not exist The following
	 *                                      exceptions make sure that only a manager
	 *                                      can execute this method by taking
	 *                                      his/her email and password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/Delete", "/Manager/Delete/" })
	public void deleteManager(@RequestParam(name = "email") String Email,
			@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		managerService.deleteManager(Email);
	}

	// update
	/**
	 * This method can only be executed by an existing Manager to update a manager's
	 * all information
	 * 
	 * @param currentEmail: email address of the manager that we will update his/her
	 *                      information
	 * @param FirsName:     new first name
	 * @param LastName:     new last name
	 * @param PhoneNumber:  new phone number
	 * @param Password:     new password
	 * @exception NullPointerException      if manager does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero The following exceptions make sure
	 *                                      that only a manager can execute this
	 *                                      method by taking his/her email and
	 *                                      password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/update/Information", "/Manager/update/Information/" })
	public void updateManagerInformation(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "LastName") String LastName,
			@RequestParam(name = "Password") String Password, @RequestParam(name = "PhoneNumber") String PhoneNumber)
			throws IllegalArgumentException {
		managerService.updateManager(Email, FirstName, LastName, PhoneNumber, Password);
	}

	/**
	 * This method can only be executed by an existing Manager to update a manager's
	 * password
	 * 
	 * @param currentEmail: email address of the manager that we will update his/her
	 *                      password
	 * @param Password:     new password
	 * @exception NullPointerException      if manager does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero The following exceptions make sure
	 *                                      that only a manager can execute this
	 *                                      method by taking his/her email and
	 *                                      password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/update/Password", "/Manager/update/Password/" })
	public void updateManagerPassword(@RequestParam(name = "email") String Email,
			@RequestParam(name = "Password") String Password) throws IllegalArgumentException {
		managerService.updateManagerPassword(Email, Password);
	}

	@PostMapping(value = { "/Manager/Update/Password", "/Manager/Update/Password/" })
	public void updateManagerPassword(@RequestParam(name = "email") String Email,
			@RequestParam(name = "password") String Password, @RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		managerService.updateManagerPassword(Email, Password);
	}

	/**
	 * This method can only be executed by an existing Manager to update a manager's
	 * first name
	 * 
	 * @param currentEmail: email address of the manager that we will update his/her
	 *                      first name
	 * @param FirstName:    new first name
	 * @exception NullPointerException      if manager does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero The following exceptions make sure
	 *                                      that only a manager can execute this
	 *                                      method by taking his/her email and
	 *                                      password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/update/FirstName", "/Manager/update/FirstName/" })
	public void updateManagerFirstName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName) throws IllegalArgumentException {
		managerService.updateManagerFirstName(Email, FirstName);
	}

	@PostMapping(value = { "/Manager/Update/FirstName", "/Manager/Update/FirstName/" })
	public void updateManagerFirstName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		managerService.updateManagerFirstName(Email, FirstName);
	}

	/**
	 * this method can only be executed by an existing Manager to update a manager's
	 * last name
	 * 
	 * @param currentEmail: email address of the manager that we will update his/her
	 *                      last name
	 * @param LastName:     new last name
	 * @exception NullPointerException      if manager does not exist
	 * @exception InvalidParameterException if any of the previous parameters equals
	 *                                      to null or the string length equals to
	 *                                      zero The following exceptions make sure
	 *                                      that only a manager can execute this
	 *                                      method by taking his/her email and
	 *                                      password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/update/LastName", "/Manager/update/LastName/" })
	public void updateManagerLastName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "LastName") String LastName) throws IllegalArgumentException {

		managerService.updateManagerLastName(Email, LastName);
	}

	// getters
	/**
	 * 
	 * @param email
	 * @param ManagerEmail
	 * @param ManagerPassword
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/Manager/get/Manager", "/Manager/get/Manager/" })
	public ManagerDto getManager(@RequestParam("email") String email,
			@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		Manager manager = managerService.getManager(email);
		return convertToDto(manager);
	}

	/**
	 * 
	 * @return
	 */

	@RequestMapping(value = { "/Manager/get/allManagers", "/Manager/get/allManagers/" })
	public List<ManagerDto> getAllManagers() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		return convertToManagerListDto(managerService.getAllManagers());
	}

	/****************** Tutor Services Controllers *********************/
	/**
	 * @Identifier F3 this method can only be executed by an existing Manager to
	 *             verify a tutor by the manager after doing the interview
	 * @param email: email of the tutor that will be verified
	 * @exception NullPointerException if tutor does not exist The following
	 *                                 exceptions make sure that only a manager can
	 *                                 execute this method by taking his/her email
	 *                                 and password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/VerifyTutor", "/Tutor/Verify/Tutor/" })
	public TutorDto verifyTutor(@RequestParam(name = "email") String Email) throws IllegalArgumentException {
		tutorService.getTutor(Email).setVerified(true);
		return convertToDto(tutorService.getTutor(Email));
	}

	/**
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param PhoneNumber
	 * @param Password
	 * @return
	 * @throws IllegalArgumentException
	 */

	@PostMapping(value = { "/Tutor/Create", "/Tutor/Create/" })
	public TutorDto createTutor(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName, @RequestParam(name = "email") String Email,
			@RequestParam(name = "phonenumber") String PhoneNumber, @RequestParam(name = "password") String Password)
			throws IllegalArgumentException {
		Tutor tutor = tutorService.createTutor(FirstName, LastName, Email, PhoneNumber, Password);
		return convertToDto(tutor);
	}

	@PostMapping(value = { "/Manager/Delete/Tutor", "/Manager/Delete/Tutor/" })
	public void deleteTutor(@RequestParam(name = "email") String Email) throws IllegalArgumentException {
		tutorService.deleteTutor(Email);
	}

	@PostMapping(value = { "/Manager/update/Tutor/Information", "/Manager/update/Tutor/Information/" })
	public void updateTutorInformation(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "LastName") String LastName,
			@RequestParam(name = "Password") String Password, @RequestParam(name = "PhoneNumber") String PhoneNumber)
			throws IllegalArgumentException {
		tutorService.updateTutor(Email, FirstName, LastName, PhoneNumber, Password);
	}

	@PostMapping(value = { "/Manager/update/Tutor/Password", "/Manager/update/Tutor/Password/" })
	public void updateTutorPassword(@RequestParam(name = "email") String Email,
			@RequestParam(name = "Password") String Password) throws IllegalArgumentException {
		tutorService.updateTutorPassword(Email, Password);
	}

	@PostMapping(value = { "/Manager/update/Tutor/FirstName", "/Manager/update/Tutor/FirstName/" })
	public void updateTutorFirstName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName) throws IllegalArgumentException {
		tutorService.updateTutorFirstName(Email, FirstName);
	}

	@PostMapping(value = { "/Manager/update/Tutor/LastName", "/Manager/update/LastName/" })
	public void updateTutorLastName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "LastName") String LastName) throws IllegalArgumentException {

		tutorService.updateTutorLastName(Email, LastName);
	}

	// getters
	/**
	 * @Identifier F6 this method can only be executed by an existing Manager to
	 *             return a tutor by giving his/her email
	 * @param email: email address of the tutor that will be returned
	 * @return tutor
	 * @exception NullPointerException if tutor does not exist The following
	 *                                 exceptions make sure that only a manager can
	 *                                 execute this method by taking his/her email
	 *                                 and password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/get/Tutor", "/Manager/get/Tutor/" })
	public TutorDto getTutor(@RequestParam("email") String email) throws IllegalArgumentException {
		Tutor tutor = tutorService.getTutor(email);
		return convertToDto(tutor);
	}

	@RequestMapping(value = { "/Manager/get/allTutors", "/Manager/get/allTutors/" })
	public List<TutorDto> getAllTutors() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		return convertToTutorListDto(tutorService.getAllTutors());
	}

	/**
	 * this method can only be executed by an existing Manager to return all the
	 * verified tutors
	 * 
	 * @return a list a verified tutors The following exceptions make sure that only
	 *         a manager can execute this method by taking his/her email and
	 *         password
	 * @param ManagerEmail     : email address of the manager uses this method
	 * @param ManagerPassword: pass word the same manager
	 * @exception NullPointerException      if the the manager (who executes this
	 *                                      method) email does not exist
	 * @exception InvalidParameterException if the manager password is wrong
	 */
	@PostMapping(value = { "/Manager/get/VerifiedTutors", "/Manager/get/VerifiedTutors/" })
	public List<TutorDto> getVerifiedTutors(@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		return convertToTutorListDto(tutorService.getVerifiedTutors());

	}

	/****************** Student Services Controllers *********************/

	@PostMapping(value = { "/Student/Create", "/Student/Create/" })
	public StudentDto createStudent(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName, @RequestParam(name = "email") String Email,
			@RequestParam(name = "phonenumber") String PhoneNumber, @RequestParam(name = "password") String Password)
			throws IllegalArgumentException {
		Student student = StudentService.createStudent(FirstName, LastName, Email, PhoneNumber, Password);
		return convertToDto(student);
	}

	@PostMapping(value = { "/Manager/Delete/Student", "/Manager/Delete/Student/" })
	public void deleteStudent(@RequestParam(name = "email") String Email) throws IllegalArgumentException {
		StudentService.deleteStudent(Email);
	}

	@PostMapping(value = { "/Manager/update/Student/Information", "/Manager/update/Student/Information/" })
	public void updateStudentInformation(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName, @RequestParam(name = "LastName") String LastName,
			@RequestParam(name = "Password") String Password, @RequestParam(name = "PhoneNumber") String PhoneNumber)
			throws IllegalArgumentException {
		StudentService.updateStudent(Email, FirstName, LastName, PhoneNumber, Password);
	}

	@PostMapping(value = { "/Manager/update/Student/Password", "/Manager/update/Student/Password/" })
	public void updateStudentPassword(@RequestParam(name = "email") String Email,
			@RequestParam(name = "Password") String Password) throws IllegalArgumentException {
		StudentService.updateStudentPassword(Email, Password);
	}

	@PostMapping(value = { "/Manager/update/Student/FirstName", "/Manager/update/Student/FirstName/" })
	public void updateStudentFirstName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "FirstName") String FirstName) throws IllegalArgumentException {
		StudentService.updateStudentFirstName(Email, FirstName);
	}

	@PostMapping(value = { "/Manager/update/Student/LastName", "/Manager/update/LastName/" })
	public void updateStudentLastName(@RequestParam(name = "email") String Email,
			@RequestParam(name = "LastName") String LastName) throws IllegalArgumentException {

		StudentService.updateStudentLastName(Email, LastName);
	}

	@RequestMapping(value = { "/Manager/get/allStudents", "/Manager/get/allStudents/" })
	public List<StudentDto> getAllStudents() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		return convertToStudentListDto(StudentService.getAllStudents());
	}

	/****************** Course Services Controllers *********************/

	@PostMapping(value = { "/Manager/Create/Course/Math", "/Manager/Create/math/Course/Math/" })
	public CourseDto createMathCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.MATH, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/Create/Course/Physics", "/Manager/Create/math/Course/Physics/" })
	public CourseDto createPhysicsCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.PHYSICS, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/Create/Course/Chemistry", "/Manager/Create/math/Course/Chemistry/" })
	public CourseDto createChemistryCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.CHEMISTRY, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/Create/Course/Biology", "/Manager/Create/math/Course/Biology/" })
	public CourseDto createBiologyCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.BIOLOGY, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/Create/Course/Languages", "/Manager/Create/math/Course/Languages/" })
	public CourseDto createLanguagesCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.LANGUAGES, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/Create/Course/Humanities", "/Manager/Create/math/Course/Humanities/" })
	public CourseDto createHumanitiesCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.createCourse(coursename, Subject.HUMANITIES, courseid);
		return convertToDto(course);

	}

	@PostMapping(value = { "/Manager/delete/Course", "/Manager/delete/Course/" })
	public void deleteCourse(@RequestParam(name = "Courseid") String Courseid) throws IllegalArgumentException {
		CourseService.deleteCourse(Courseid);
	}

	@PostMapping(value = { "/Manager/update/Course", "/Manager/update/Course/" })

	public CourseDto updateCourse(@RequestParam(name = "coursename") String coursename,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {

		Course course = CourseService.getCourse(courseid);
		course.setName(coursename);
		return convertToDto(course);

	}

	@RequestMapping(value = { "/Manager/get/allCourses", "/Manager/get/allCourses/" })
	public List<CourseDto> getAllCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		return convertToCourseListDto(CourseService.getAllCourses());
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Math", "/Manager/get/allCourses/Math/" })
	public List<CourseDto> getAllMathCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.MATH);
		return convertToCourseListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Physics", "/Manager/get/allCourses/Physics/" })
	public List<CourseDto> getAllPhysicsCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.PHYSICS);
		return convertToCourseListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Chemistry", "/Manager/get/allCourses/Chemistry/" })
	public List<CourseDto> getAllChemistryCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.CHEMISTRY);
		return convertToCourseListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Biology", "/Manager/get/allCourses/Biology/" })
	public List<CourseDto> getAllBiologyCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.BIOLOGY);
		return convertToCourseListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Languages", "/Manager/get/allCourses/Languages/" })
	public List<CourseDto> getAllLanguagesCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.LANGUAGES);
		return convertToCourseListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/allCourses/Humanities", "/Manager/get/allCourses/Humanities/" })
	public List<CourseDto> getAllHumanitiesCourses() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		ArrayList<Course> result = CourseService.getAllCoursesBySubject(Subject.HUMANITIES);
		return convertToCourseListDto(result);
	}

	/****************** Offering Services Controllers *********************/

	@PostMapping(value = { "/Tutor/Create/Offering", "/Tutor/Create/Offering/" })
	public OfferingDto createOffering(@RequestParam(name = "individualPrice") int individualPrice,
			@RequestParam(name = "GroupPrice") int GroupPrice, @RequestParam(name = "tutoremail") String tutoremail,
			@RequestParam(name = "courseid") String courseid) throws IllegalArgumentException {
		Offering offering = OfferingService.createOffering(individualPrice, GroupPrice,
				CourseService.getCourse(courseid), tutorService.getTutor(tutoremail));

		// Course course = CourseService.createCourse(coursename, Subject.MATH,
		// courseid);
		return convertToDto(offering);
	}

	/****************** Session Services Controllers *********************/

	/**
	 * This methods allows the manager to create an individual session
	 * 
	 * @param tutorEmail
	 * @param year
	 * @param month
	 * @param day
	 * @param Roomid
	 * @param startinHour
	 * @param startingMinute
	 * @param endingHour
	 * @param endingMinute
	 * @param studentEmails
	 * @exception IllegalArgumentException  if the tutorEmail is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/Create/Session", "/Manager/CreateSession/" })
	public SessionDto CreatSession(@RequestParam(name = "year") int year, @RequestParam(name = "month") int month,
			@RequestParam(name = "day") int day, @RequestParam(name = "startingHour") int startingHour,
			@RequestParam(name = "startingMinute") int startingMinute,
			@RequestParam(name = "endingHour") int endingHour, @RequestParam(name = "endingMinute") int endingMinute,
			@RequestParam(name = "roomid") int roomid, @RequestParam(name = "tutoremail") String tutor,
			@RequestParam(name = "offeringid") int offeringid,
			@RequestParam(name = "studentEmail1", required = false) String studentEmail1,
			@RequestParam(name = "studentEmail2", required = false) String studentEmail2,
			@RequestParam(name = "studentEmail3", required = false) String studentEmail3,
			@RequestParam(name = "studentEmail4", required = false) String studentEmail4,
			@RequestParam(name = "studentEmail5", required = false) String studentEmail5

	) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		Set<Student> students = new HashSet<Student>();
		//if(studentEmail1 != "" ||studentEmail1!=null ) {
			Student student1 = StudentService.getStudent(studentEmail1);			
			students.add(student1);
	//	}
			if(studentEmail2 != "" && studentEmail2!=null ) {
			Student student2 = StudentService.getStudent(studentEmail2);			
			students.add(student2);
			}
			
			if(studentEmail3 != "" &&studentEmail3!=null ) {
			Student student3 = StudentService.getStudent(studentEmail3);			
			students.add(student3);
			}
			
			if(studentEmail4 != "" &&studentEmail4!=null ) {
			Student student4 = StudentService.getStudent(studentEmail4);			
			students.add(student4);
			}
			
			if(studentEmail5 != "" &&studentEmail5!=null ) {
			Student student5 = StudentService.getStudent(studentEmail5);			
			students.add(student5);
			}
			
		Session session = SessionService.createSession(year, month, day, startingHour, startingMinute, endingHour,
				endingMinute, RoomService.getRoom(roomid), tutorService.getTutor(tutor),
				OfferingService.getSpecificOffering(offeringid), students);

		return convertToDto(session);

	}

	@RequestMapping(value = { "/Manager/get/PendingSessions", "/Manager/getPendingSessions" })
	public List<SessionDto> getAllGroupSession() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		List<Session> result = SessionService.getPendingGroupSession();
		return convertToSessionListDto(result);
	}
	
	@RequestMapping(value = { "/Manager/get/allSessions", "/Manager/getAllSessions" })
	public List<SessionDto> getAllSession() {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		List<Session> result = SessionService.getAllSessions();
		return convertToSessionListDto(result);
	}

	@RequestMapping(value = { "/Manager/get/Tutor/Sessions", "/Manager/getTutorSessions" })
	public List<SessionDto> getTutorSession(@RequestParam(name = "tutorEmail") String tutorEmail) {
		
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		List<Session> result = SessionService.getTutorSessions(tutorService.getTutor(tutorEmail));
		return convertToSessionListDto(result);
	}

	/**
	 * This methods allows the manager to delete a session by entering the
	 * tutorEmail and the startingTime
	 * 
	 * @param tutorEmail
	 * @param startingTime (only hour assuming there is no session that would last
	 *                     for less than an hour.)
	 * @exception IllegalArgumentException  if the tutorEmail is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@DeleteMapping(value = { "/Manager/Delete/Session", "/Manager/delete/session/" })
	public void deleteSession(@RequestParam(name = "sartingTime") int startingTime,
			@RequestParam(name = "tutorEmail") String tutorEmail) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		SessionService.deleteSession(tutorService.getTutor(tutorEmail), startingTime);
		;
	}

	/**
	 * This methods allows the manager to confirm a pending group session by entering the
	 * tutorEmail and the startingTime and the room they want
	 * 
	 * @param tutorEmail
	 * @param startingTime (only hour assuming there is no session that would last
	 *                     for less than an hour.)
	 * @exception IllegalArgumentException  if the tutorEmail is not entered
	 * @exception InvalidParameterException if the manager did not log in
	 */
	@PostMapping(value = { "/Manager/confirm/session", "/Manager/Confirm/Session/" })
	public String confirmSession(@RequestParam(name = "sartingTime") int startingTime,
			@RequestParam(name = "tutorEmail") String tutorEmail, @RequestParam(name = "roomNumber") int roomNumber) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}
		SessionService.confirmSession(tutorService.getTutor(tutorEmail), startingTime, RoomService.getRoom(roomNumber));
		;
		return "The Session has been confirmed";
	}
	
	
	/****************** Course Services Controllers *********************/

	@PostMapping(value = { "/Manager/Create/Course", "/Manager/Create/Course/" })
	public Course createCourse(@RequestParam(name = "name") String name,
			@RequestParam(name = "course_id") String course_id) throws IllegalArgumentException {
		if (!ManagerLoggedin) {
			throw new InvalidParameterException("you did not log in");
		}

		Course course = CourseService.createCourse(name, Subject.BIOLOGY, course_id);
		return course;
	}

	@PostMapping(value = { "/Manager/Create/Student", "/Manager/Create/Student/" })
	public Student createStudent(@RequestParam(name = "firstName") String FirstName,
			@RequestParam(name = "lastName") String LastName, @RequestParam(name = "email") String Email,
			@RequestParam(name = "phonenumber") String PhoneNumber, @RequestParam(name = "password") String Password,
			@RequestParam(name = "ManagerEmail") String ManagerEmail,
			@RequestParam(name = "ManagerPassword") String ManagerPassword) throws IllegalArgumentException {
		if (!managerRepository.existsById(ManagerEmail)) {
			throw new NullPointerException("manager Does not Exist");
		}
		if (!managerService.getManager(ManagerEmail).getPassword().contentEquals(ManagerPassword)) {
			throw new InvalidParameterException("Incorrect Password");
		}
		Student student = StudentService.createStudent(FirstName, LastName, Email, PhoneNumber, Password);
		return student;
	}

	@PostMapping(value = { "/t/review", "/t/review/" })
	public TutorReviews review(@RequestParam(name = "stares") int stars, @RequestParam(name = "body") String body,
			@RequestParam(name = "email") String email) throws IllegalArgumentException {
		TutorReviews review = tutorReviewsService.createTutorReview(body, stars, email);
		return review;
	}
	
	/****************** Convert To methods Controllers *********************/
	
	//TODO : the rest of them.
	
	private StudentDto convertToDto(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}

		StudentDto studentDto = new StudentDto(student.getFirst_name(), student.getLast_name(), student.getEmail(),
				student.getPhone_number(), student.getPassword());
		return studentDto;
	}

	private TutorDto convertToDto(Tutor tutor) {
		if (tutor == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		boolean verified = false;
		if (tutor.isVerified()) {
			verified = true;
		}
		TutorDto tutorDto = new TutorDto(tutor.getFirst_name(), tutor.getLast_name(), tutor.getEmail(),
				tutor.getPhone_number(), tutor.getPassword(), verified);
		return tutorDto;
	}

	private CourseDto convertToDto(Course course) {
		if (course == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}

		CourseDto courseDto = new CourseDto(course.getName(), course.getSubject(), course.getCourse_id());

		return courseDto;
	}

	private ManagerDto convertToDto(Manager manager) {
		if (manager == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		ManagerDto managerDto = new ManagerDto(manager.getFirst_name(), manager.getLast_name(), manager.getEmail(),
				manager.getPhone_number(), manager.getPassword());
		return managerDto;
	}

	private OfferingDto convertToDto(Offering offering) {
		if (offering == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		OfferingDto offeringDto = new OfferingDto(offering.getPrice_individual(), offering.getPrice_group(),
				offering.getId(), offering.getTutor(), offering.getCourse());
		return offeringDto;
	}

	private SessionDto convertToDto(Session session) {
		if (session == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		OfferingDto offeringDto = convertToDto(session.getOffering());
		SessionDto sessionDto = new SessionDto(session.getStart_time(), session.getEnd_time(), session.getDate(), offeringDto, session.getStudent().size());
		return sessionDto;
	}

	private RoomDto convertToDto(Room room) {
		if (room == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		RoomDto roomDto = new RoomDto(room.getNumber(), room.getRoom_type());
		return roomDto;
	}

	private List<RoomDto> convertToRoomListDto(List<Room> listRoom) {
		if (listRoom == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<RoomDto> listRoomDto = new ArrayList<RoomDto>();
		for (Room room : listRoom) {
			listRoomDto.add(convertToDto(room));
		}

		return listRoomDto;
	}

	private List<ManagerDto> convertToManagerListDto(List<Manager> listManager) {
		if (listManager == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<ManagerDto> listManagerDto = new ArrayList<ManagerDto>();
		for (Manager manager : listManager) {
			listManagerDto.add(convertToDto(manager));
		}

		return listManagerDto;
	}

	private List<CourseDto> convertToCourseListDto(List<Course> listCourse) {
		if (listCourse == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<CourseDto> listCourseDto = new ArrayList<CourseDto>();
		for (Course course : listCourse) {
			listCourseDto.add(convertToDto(course));
		}

		return listCourseDto;
	}

	private List<SessionDto> convertToSessionListDto(List<Session> listSession) {
		if (listSession == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<SessionDto> listSessionDto = new ArrayList<SessionDto>();
		for (Session session : listSession) {
			listSessionDto.add(convertToDto(session));
		}

		return listSessionDto;
	}

	private List<TutorDto> convertToTutorListDto(List<Tutor> listTutor) {
		if (listTutor == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<TutorDto> listTutorDto = new ArrayList<TutorDto>();
		for (Tutor tutor : listTutor) {
			listTutorDto.add(convertToDto(tutor));
		}

		return listTutorDto;
	}

	private List<StudentDto> convertToStudentListDto(List<Student> listStudent) {
		if (listStudent == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		List<StudentDto> listStudentDto = new ArrayList<StudentDto>();
		for (Student student : listStudent) {
			listStudentDto.add(convertToDto(student));
		}

		return listStudentDto;
	}

}
