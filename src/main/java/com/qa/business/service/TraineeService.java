package com.qa.business.service;

import com.qa.persistance.domain.Trainee;

public interface TraineeService {
	public Trainee findTrainee(Long traineeID);

	public String findAllTrainees();

	public String createTrainee(String newTrainee);

	public String updateTrainee(Long traineeID, String updateTrainee);

	public String deleteTrainee(Long traineeID);
}
