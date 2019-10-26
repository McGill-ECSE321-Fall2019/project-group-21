package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.tutoringcompany.dao.OfferingRepository;
import ca.mcgill.ecse321.tutoringcompany.model.Course;
import ca.mcgill.ecse321.tutoringcompany.model.Offering;
import ca.mcgill.ecse321.tutoringcompany.model.Tutor;

/**
 * 
 * @author George Kandalaft
 *
 */

@Service
public class TutoringCompanyOfferingService {

	@Autowired
	OfferingRepository OfferingRepository;

	/**
	 * Create Offering
	 *
	 * @param individualPrice individual Price
	 * @param grouplPrice     group price
	 * @param course          The course offered
	 * @param tutor           The tutor
	 * 
	 * @return The Offering.
	 */

	@Transactional
	public Offering createOffering(int individualPrice, int grouplPrice, Course course, Tutor tutor) {

		Offering offering = new Offering();
		offering.setPrice_individual(individualPrice);
		offering.setPrice_group(individualPrice);
		offering.setTutor(tutor);
		offering.setCourse(course);
		OfferingRepository.save(offering);

		return offering;
	}

	/**
	 * Get Offerings by Tutor
	 * 
	 * @param tutor
	 * @return a list of Offerings of this tutor
	 */

	@Transactional
	public List<Offering> getOfferingByTutor(Tutor tutor) { //should be called getOfferings
		List<Offering> offeringsByTutor = new ArrayList<>();
		for (Offering offering : OfferingRepository.findOfferingByTutor(tutor)) {
			offeringsByTutor.add(offering);
		}
		return offeringsByTutor;
	}

	/**
	 * Get all Offerings in the system.
	 *
	 * @return a list of Offerings representing all Offerings in the system.
	 */

	@Transactional
	public List<Offering> getAllOfferings() {
		return (List<Offering>) OfferingRepository.findAll();
	}
	
	
	/**
	 * Get a offering for a tutor in a specific course by id.
	 * 
	 * @param id
	 * 
	 * @exception NullPointerException if {@code offering} is null
	 * 
	 * @return offering
	 */

	@Transactional
	public Offering getSpecificOffering(int id) {
		try {
			Offering offering = OfferingRepository.findById(id).get();
			return offering;
		} catch (NoSuchElementException e) {
			throw new NullPointerException("No such Offering.");
		}
	}
	
	/**
	 * Get a offering for a tutor in a specific course by tutor and course.
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if {@code offering} is null
	 * 
	 * @return offering
	 */

	@Transactional
	public Offering getSpecificOffering(Tutor tutor, Course course) {
		Offering offering = null;
		//List<Offering> offeringsByTutor = getOfferingByTutor(tutor);
		for (Offering offeringByTutor : getOfferingByTutor(tutor)) {
			if (offeringByTutor.getCourse().equals(course)) {// || offeringByTutor.getTutor().equals(tutor)) {
				offering = offeringByTutor;
				break;
			}
		}
		if (offering == null) {
			throw new NullPointerException("No such Offering.");
		}
		return offering;
	}

	/**
	 * Delete offering with the specific id
	 * 
	 * @param id of the offering
	 * 
	 * @exception NullPointerException if {@code offering} is null
	 * 
	 */

	@Transactional
	public void deleteOffering(int id) {
		getSpecificOffering(id); //throw exception if offering DNE
		OfferingRepository.deleteById(id);
	}

	/**
	 * Delete offering with a specific course for a specific tutor.
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if {@code offering} is null
	 * 
	 */

	@Transactional
	public void deleteOffering(Tutor tutor, Course course) {
		Offering offering = getSpecificOffering(tutor, course); //exception falls through to caller
		OfferingRepository.deleteById(offering.getId());
//		Offering offering = null;
//		//List<Offering> offeringsByTutor = getOfferingByTutor(tutor);
//		for (Offering offeringByTutor : getOfferingByTutor(tutor)) {
//			if (offeringByTutor.getCourse().equals(course)) { // || offeringByTutor.getTutor().equals(tutor)) {
//				offering = offeringByTutor;
//				break;
//			}
//		}
//		if (offering == null) {
//			throw new NullPointerException("No such Offering.");
//		} else {
//			OfferingRepository.deleteById(offering.getId());
//		}
	}
}
