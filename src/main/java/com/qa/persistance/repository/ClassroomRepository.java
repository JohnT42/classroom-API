package com.qa.persistance.repository;

import com.qa.persistance.domain.Classroom;

public interface ClassroomRepository {
		public Classroom findClassroom(Long classroomID);

		public String findAllClassrooms();

		public String createClassroom(String newClassroom);

		public String updateClassroom(Long classroomID, String updateClassroom);

		public String deleteClassroom(Long classroomID);
}

