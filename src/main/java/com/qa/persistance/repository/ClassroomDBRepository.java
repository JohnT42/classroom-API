package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class ClassroomDBRepository implements  ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public  Classroom findClassroom(Long classroomID) {
		return em.find(Classroom.class,  classroomID);
	}

	public String findAllClassrooms() {
	        TypedQuery<Classroom> query = em.createQuery("SELECT c FROM Classroom c", Classroom.class);
	        return util.getJSONForObject(query.getResultList());
	    }


	@Transactional(REQUIRED) 
	public String createClassroom(String newclassroom) {
		Classroom aClassroom = util.getObjectForJSON(newclassroom, Classroom.class);
		em.persist(aClassroom);
		return "{\"message\": \"Classroom added\"}";
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