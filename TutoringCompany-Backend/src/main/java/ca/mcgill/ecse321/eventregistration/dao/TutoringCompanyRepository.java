package ca.mcgill.ecse321.eventregistration.dao;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Person;
@Repository
public class TutoringCompanyRepository {

	@Autowired
	EntityManager entityManager;
	@Transactional
	public Person createPerson(String name) {
	Person p = new Person();
	p.setFirst_name(name); 
	entityManager.persist(p);
	return p;
	}
	@Transactional
	public Person getPerson(String name) {
	Person p = entityManager.find(Person.class, name);
	return p;
	}
	
	
	
}


