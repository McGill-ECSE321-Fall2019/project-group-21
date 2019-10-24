package ca.mcgill.ecse321.tutoringcompany.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestManager.class, TestStudent.class, TestTutor.class })
public class AllTests {

}
