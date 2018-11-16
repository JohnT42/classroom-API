package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Classroom;
import com.qa.persistance.repository.ClassroomRepository;

public class ClassroomServiceImplementation implements ClassroomService{
	@Inject
	private ClassroomRepository classRepo;
	
	public Classroom findClassroom(Long classroomID) {
		return classRepo.findClassroom(classroomID);
	}
	
	public String findAllClassrooms() {
		return classRepo.findAllClassrooms();
	}

	
	public String createClassroom(String newClassroom) {
		return classRepo.createClassroom(newClassroom);
	}

	
	public String updateClassroom(Long classroomID, String updateClassroom) {
		return classRepo.updateClassroom(classroomID, updateClassroom);
	}

	
	public String deleteClassroom(Long classroomID) {
		return classRepo.deleteClassroom(classroomID);
	}

	

}
