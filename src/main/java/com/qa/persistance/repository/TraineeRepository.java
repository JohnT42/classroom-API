package com.qa.persistance.repository;

import com.qa.persistance.domain.Trainee;

public interface TraineeRepository {
		public Trainee findTrainee(Long traineeID);

		public String findAllTrainees();

		public String createTrainee(String newTrainee);

		public String updateTrainee(Long traineeID, String updateTrainee);

		public String deleteTrainee(Long traineeID);
}

