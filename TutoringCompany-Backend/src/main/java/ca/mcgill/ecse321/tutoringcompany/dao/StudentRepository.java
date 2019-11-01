package ca.mcgill.ecse321.tutoringcompany.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringcompany.model.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;

public interface StudentRepository extends CrudRepository<Student, String> {

	Student findByEmail(String email);
}