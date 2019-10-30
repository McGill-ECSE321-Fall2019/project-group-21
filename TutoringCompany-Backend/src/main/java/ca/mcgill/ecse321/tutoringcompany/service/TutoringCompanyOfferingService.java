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
import ca.mcgill.ecse321.tutoringcompany.model.Subject;
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
	OfferingRepository offeringRepository;

	/**
	 * Create Offering instance with the given parameters, save it, and return it
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
		offeringRepository.save(offering);
		return offering;
	}

	/**
	 * Read List of Offerings by Tutor
	 * 
	 * @param tutor
	 * @return List of Offerings offered by the given tutor
	 * 
	 * @exception NullPointerException if no offerings by that tutor exist
	 */
//	@Transactional
//	public List<Offering> getOfferingByTutor(Tutor tutor) { //should be called getOfferings
//		List<Offering> offeringsByTutor = new ArrayList<>();
//		for (Offering offering : offeringRepository.findOfferingByTutor(tutor)) {
//			offeringsByTutor.add(offering);
//		}
//		return offeringsByTutor;
//	}

	/**
	 * Read List of all Offerings in the system
	 *
	 * @return List of Offerings representing all Offerings in the system
	 */
	@Transactional
	public List<Offering> getAllOfferings() {
		return (List<Offering>) offeringRepository.findAll();
	}
	
	/**
	 * Read a specific offering by its id
	 * 
	 * @param id
	 * 
	 * @exception NullPointerException if offering with that id does not exist
	 * 
	 * @return offering
	 */
	@Transactional
	public Offering getSpecificOffering(int id) { //should be called getOffering
		try {
			return offeringRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NullPointerException("No such Offering.");
		}
	}
	
	/**
	 * Read a specific offering for a given course by a given tutor
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if offering by that tutor and for that course does not exist
	 * 
	 * @return offering
	 */
//	@Transactional
//	public Offering getSpecificOffering(Tutor tutor, Course course) { //should be called getOffering
//		//List<Offering> offeringsByTutor = getOfferingByTutor(tutor);
//		for (Offering offeringByTutor : getOfferingByTutor(tutor)) {
//			if (offeringByTutor.getCourse().equals(course)) {// || offeringByTutor.getTutor().equals(tutor)) {
//				return offeringByTutor;
//			}
//		}
//		throw new NullPointerException("No such Offering.");
//	}
	
	/**
	 * Update price_individual for the specific offering passed
	 * 
	 * @param id
	 * @param price_individual
	 */
	@Transactional
	public void updatePrice_individual(Offering offering, int price_individual) {
		getSpecificOffering(offering.getId()).setPrice_individual(price_individual);
	}
	
	/**
	 * Update price_individual for the specific offering passed
	 * 
	 * @param id
	 * @param price_group
	 */
	@Transactional
	public void updatePrice_group(Offering offering, int price_group) {
		getSpecificOffering(offering.getId()).setPrice_group(price_group);
	}
	
	/**
	 * Delete the specific offering passed
	 * 
	 * @param offering
	 */
	@Transactional
	public void deleteOffering(Offering offering) {
		offeringRepository.delete(offering);
	}
	
	/**
	 * Delete an offering specified by the given id
	 * 
	 * @param id of the offering to delete
	 * 
	 * @exception NullPointerException if offering with that id does not exist
	 * 
	 */
	@Transactional
	public void deleteOffering(int id) {
		offeringRepository.delete(getSpecificOffering(id)); //throw exception if offering DNE
	}

	/**
	 * Delete specific offering for a given course by a given tutor
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if offering by that tutor and that course does not exist
	 * 
	 */
//	@Transactional
//	public void deleteOffering(Tutor tutor, Course course) {
//		deleteOffering(getSpecificOffering(tutor, course));
//	}
	
	/**
	 * Delete all offerings by a given tutor
	 * 
	 * @param tutor
	 */
//	@Transactional
//	public void deleteOfferings(Tutor tutor) {
//		for (Offering offering : getOfferingByTutor(tutor)) {
//			deleteOffering(offering);
//		}
//	}
}
