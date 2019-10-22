package ca.mcgill.ecse321.tutoringcompany;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringcompany.model.Student;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoringCompanyApplication {
	@Autowired
	private TutoringCompanyService service;
  public static void main(String[] args) {
    SpringApplication.run(TutoringCompanyApplication.class, args);
  }

  @RequestMapping("/")
  public Student greeting(){
	   return service.getstudent("eliasso");
  }

}

