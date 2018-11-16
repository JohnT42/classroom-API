package com.qa.business.service;

import com.qa.persistance.domain.Classroom;

public interface ClassroomService {
	
	public Classroom findClassroom(Long classroomID);

	public String findAllClassrooms();

	public String createClassroom(String newClassroom);

	public String updateClassroom(Long classroomID, String updateClassroom);

	public String deleteClassroom(Long classroomID);
}