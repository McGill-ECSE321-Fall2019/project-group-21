package ca.mcgill.ecse321.tutoringcompany.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Offering> getOfferingByTutor(Tutor tutor) {
		List<Offering> offeringsByTutor = new ArrayList<>();
		for (Offering ot : OfferingRepository.findOfferingByTutor(tutor)) {
			offeringsByTutor.add(ot);
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
	 * Get a offering for a tutor in a specific course.
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
		Offering sto = null;
		List<Offering> offeringsByTutor = getOfferingByTutor(tutor);
		for (Offering so : offeringsByTutor) {
			if (so.getCourse().equals(course) || so.getTutor().equals(tutor)) {
				sto = so;
			}
			if (sto == null) {

				throw new NullPointerException("No such Offering.");
			}

		}
		return sto;
	}

	/**
	 * delete offering with the specific id
	 * 
	 * @param id of the offering
	 * 
	 */

	@Transactional
	public void deleteOffering(int ofID) {
		Offering offering = OfferingRepository.findById(ofID);
		if (offering == null) {
			throw new NullPointerException("No such Offering.");
		}
		OfferingRepository.deleteById(ofID);
	}

	/**
	 * delete offering with a specific course for a specific tutor.
	 * 
	 * @param id     of the offering
	 * 
	 * @param tutor
	 * @param course
	 * 
	 * @exception NullPointerException if {@code offering} is null
	 * 
	 */

	@Transactional
	public void deleteOffering(Tutor tutor, Course course) {
		Offering sto = null;
		List<Offering> offeringsByTutor = getOfferingByTutor(tutor);
		for (Offering so : offeringsByTutor) {
			if (so.getCourse().equals(course) || so.getTutor().equals(tutor)) {
				sto = so;
			}
			if (sto == null) {

				throw new NullPointerException("No such Offering.");
			} else {
				int ofID = sto.getId();
				OfferingRepository.deleteById(ofID);
			}

		}
	}
}
