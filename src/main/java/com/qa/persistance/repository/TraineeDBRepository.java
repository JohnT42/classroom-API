package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements  ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public  Classroom findClassroom(Long classroomID) {
		return em.find(Classroom.class,  classroomID);
	}

	public String findAllClassrooms() {
	        TypedQuery<Classroom> query = em.createQuery("SELECT a FROM Accounts a", Classroom.class);
	        return util.getJSONForObject(query.getResultList());
	    }


	@Transactional(REQUIRED) 
	public String createClassroom(String newaccount) {
		Classroom anAccount = util.getObjectForJSON(newaccount, Classroom.class);
		em.persist(anAccount);
		return "{\"message\": \"account added\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long classroomID, String updateclassroom) {
		Classroom updatedClassroom = util.getObjectForJSON(updateclassroom, Classroom.class);
		Classroom classroomFromDB = findClassroom(classroomID);
		if (updatedClassroom != null || classroomFromDB != null) {
			classroomFromDB.setTrainer(updatedClassroom.getTrainer());
			em.merge(classroomFromDB);
		}
		return "{\"message\": \"Classroom updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		Classroom classroomInDB = findClassroom(classroomID);
		if (classroomInDB != null) {
			em.remove(classroomInDB);
		}
		return "{\"message\": \"Classroom deleted\"}";
	}
}