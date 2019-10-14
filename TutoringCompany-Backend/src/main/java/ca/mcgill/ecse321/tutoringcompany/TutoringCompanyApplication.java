package ca.mcgill.ecse321.tutoringcompany;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class TutoringCompanyApplication {

  public static void main(String[] args) {
    SpringApplication.run(TutoringCompanyApplication.class, args);
  }

  @RequestMapping("/")
  public String greeting(){
    return "Hello World!";
  }

}

