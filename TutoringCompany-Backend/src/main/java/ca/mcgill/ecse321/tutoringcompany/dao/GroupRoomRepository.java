package ca.mcgill.ecse321.tutoringcompany.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;

import ca.mcgill.ecse321.tutoringcompany.model.GroupRoom;


@CrossOrigin(origins = "*")
public interface GroupRoomRepository extends CrudRepository<GroupRoomRepository, String> {
	GroupRoom findByNumber(@Param(value = "id") String id);
	

	GroupRoom save(GroupRoom groupRoom);
}
