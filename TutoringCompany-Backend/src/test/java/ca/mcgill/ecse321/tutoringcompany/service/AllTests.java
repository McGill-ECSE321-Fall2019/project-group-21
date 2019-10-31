package ca.mcgill.ecse321.tutoringcompany.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCourse.class, TestManager.class, TestOffering.class, TestRoom.class, TestStudent.class,
		TestStudentReviews.class, TestTutor.class, TestTutorReviews.class })
public class AllTests {

}
