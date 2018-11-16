package com.qa.interoperability.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;
import com.qa.persistance.domain.Trainee;

@Path("/trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeService traineeService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String findAllTrainees() {
		return traineeService.findAllTrainees();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String createTrainee(String newTrainee) {
		return traineeService.createTrainee(newTrainee);
	}

	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public Trainee findTraineem(@PathParam("id") Long traineeID) {
		return traineeService.findTrainee(traineeID);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long traineeID, String updateTrainee) {
		return traineeService.updateTrainee(traineeID, updateTrainee);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long traineeID) {
		return traineeService.deleteTrainee(traineeID);
	}
}