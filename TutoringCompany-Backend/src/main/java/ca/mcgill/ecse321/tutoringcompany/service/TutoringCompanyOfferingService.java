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
 * @author Louca Dufault
 *
 */

@Service
public class TutoringCompanyOfferingService {

	@Autowired
	OfferingRepository OfferingRepository;

	/**
	 * Create Offering instance and return it
	 *
	 * @param individualPrice
	 * @param grouplPrice
	 * @param course offered
	 * @param tutor
	 *  
	 * @return the created offering
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
	 * Get List of Offerings by Tutor
	 * 
	 * @param tutor
	 * @return List of Offerings offered by the given tutor
	 * 
	 * @exception NullPointerException if no offerings by that tutor exist
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
	 * Get List of all Offerings in the system
	 *
	 * @return List of Offerings representing all Offerings in the system
	 */
	@Transactional
	public List<Offering> getAllOfferings() {
		return (List<Offering>) OfferingRepository.findAll();
	}
	
	/**
	 * Get a specific offering by its id
	 * 
	 * @param id
	 * 
	 * @exception NullPointerException if offering by that id does not exist
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
	 * Get a specific offering for a given course by a given tutor
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if offering by that tutor and course does not exist
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
	 * Delete specific offering with the given id
	 * 
	 * @param id of the offering
	 * 
	 * @exception NullPointerException if offering by that id does not exist
	 * 
	 */
	@Transactional
	public void deleteOffering(int id) {
		getSpecificOffering(id); //throw exception if offering DNE
		OfferingRepository.deleteById(id);
	}

	/**
	 * Delete specific offering for a given course by a given tutor
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if offering by that tutor and course does not exist
	 * 
	 */
	@Transactional
	public void deleteOffering(Tutor tutor, Course course) {
		Offering offering = getSpecificOffering(tutor, course); //exception falls through to caller
		deleteOffering(offering.getId());
		//OfferingRepository.deleteById(offering.getId());
	}
	
	/**
	 * Delete all offerings by a given tutor
	 * 
	 * @param tutor
	 */
	@Transactional
	public void deleteOfferings(Tutor tutor) {
		for (Offering offering : getOfferingByTutor(tutor)) {
			deleteOffering(offering.getId());
		}
	}
}
