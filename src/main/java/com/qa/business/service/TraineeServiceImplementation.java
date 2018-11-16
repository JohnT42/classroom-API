package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.domain.Trainee;
import com.qa.persistance.repository.TraineeRepository;

public class TraineeServiceImplementation implements TraineeService {
	@Inject
	private TraineeRepository traineeRepo;

	public Trainee findTrainee(Long traineeID) {
		return traineeRepo.findTrainee(traineeID);
	}

	public String findAllTrainees() {
		return traineeRepo.findAllTrainees();
	}

	public String createTrainee(String newTrainee) {
		return traineeRepo.createTrainee(newTrainee);
	}

	public String updateTrainee(Long traineeID, String updateTrainee) {
		return traineeRepo.updateTrainee(traineeID, updateTrainee);
	}

	public String deleteTrainee(Long traineeID) {
		return traineeRepo.deleteTrainee(traineeID);
	}

}
