package com.qa.persistance.repository;

import com.qa.persistance.domain.Classroom;

public interface TraineeRepository {
		public Classroom findTrainee(Long traineeID);

		public String findAllTrainees();

		public String createTrainees(String newTrainee);

		public String updateTrainee(Long traineeID, String updateTrainee);

		public String deleteTrainee(Long traineeID);
}

