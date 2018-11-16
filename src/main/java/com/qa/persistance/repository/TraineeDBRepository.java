package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class TraineeDBRepository implements  TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public  Trainee findTrainee(Long traineeID) {
		return em.find(Trainee.class,  traineeID);
	}

	public String findAllTrainees() {
	        TypedQuery<Trainee> query = em.createQuery("SELECT t FROM Trainee t", Trainee.class);
	        return util.getJSONForObject(query.getResultList());
	    }


	@Transactional(REQUIRED) 
	public String createTrainee(String newaccount) {
		Trainee anAccount = util.getObjectForJSON(newaccount, Trainee.class);
		em.persist(anAccount);
		return "{\"message\": \"Trainee added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long traineeID, String updatetrainee) {
		Trainee updatedTrainee = util.getObjectForJSON(updatetrainee, Trainee.class);
		Trainee traineeFromDB = findTrainee(traineeID);
		if (updatedTrainee != null || traineeFromDB != null) {
			traineeFromDB.setTrainee(updatedTrainee.getTrainee());
			traineeFromDB.setClassrm(updatedTrainee.getClassrm());
			em.merge(traineeFromDB);
		}
		return "{\"message\": \"Trainee updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		Trainee traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			em.remove(traineeInDB);
		}
		return "{\"message\": \"Trainee deleted\"}";
	}
}