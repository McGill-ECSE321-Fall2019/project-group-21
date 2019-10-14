package TestPersistenceClasses;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.tutoringcompany.dao.ManagerRepository;
import ca.mcgill.ecse321.tutoringcompany.model.*;
import ca.mcgill.ecse321.tutoringcompany.service.TutoringCompanyService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManager {
    @Autowired
    ManagerRepository ManagerRepository;
    @Autowired
    TutoringCompanyService service;
    @Test
    public void testCreateManager() {
        assertEquals(0, service.getAllManagers().size());
        
        String firstName = "fName";
        String lastName = "lName";
        String phone = "phone";
        String email = "email";
        String password = "password";
        
        try {
            service.createManager(firstName, lastName, phone, email, password);
        } catch (IllegalArgumentException e) {
            fail();
        }
        
        List<Manager> allManagers = service.getAllManagers();
        
        assertEquals(1, allManagers.size());
        assertEquals(email, allManagers.get(0).getPerson().getEmail());
        
        ManagerRepository.deleteAll();
    }
    
    @Test
    public void testReadManager() {
        assertEquals(0, service.getAllManagers().size());
        
        String firstName = "fName";
        String lastName = "lName";
        String phone = "phone";
        String email = "email";
        String password = "password";
        
        service.createManager(firstName, lastName, phone, email, password);
        try {
            Manager m = service.getManager(email);
        } catch (IllegalArgumentException e){
            fail();
        }
        Manager m = service.getManager(email);
        assertEquals(firstName, m.getPerson().getFirst_name());
        assertEquals(lastName, m.getPerson().getLast_name());
        assertEquals(phone, m.getPerson().getPhone());
        assertEquals(email, m.getPerson().getEmail());
        assertEquals(password, m.getPerson().getPassword());
        
        ManagerRepository.deleteAll();
    }
}