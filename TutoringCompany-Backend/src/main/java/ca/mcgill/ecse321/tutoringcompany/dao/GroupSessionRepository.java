package ca.mcgill.ecse321.tutoringcompany.dao;


import org.springframework.data.repository.CrudRepository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import org.springframework.web.bind.annotation.CrossOrigin;

import ca.mcgill.ecse321.tutoringcompany.model.GroupSession;
import ca.mcgill.ecse321.tutoringcompany.model.IndividualSession;

@CrossOrigin(origins = "*")
public interface GroupSessionRepository extends CrudRepository<GroupSession, String> {

	IndividualSession findByid(@Param(value = "id") int id);
	
		

  Iterable<GroupSession> findAll();

 
  GroupSession save(GroupSession groupSession);
}