package com.qa.interoperability.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;
import com.qa.persistance.domain.Classroom;

@Path("/classroom")
public class ClassroomEndpoint {
	@Inject
	private ClassroomService classroomService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String findAllClassrooms() {
		return classroomService.findAllClassrooms();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String createClassroom(String newClassroom) {
		return classroomService.createClassroom(newClassroom);
	}

	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public Classroom findClassroom(@PathParam("id") Long classroomID) {
		return classroomService.findClassroom(classroomID);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long classroomID, String updateClassroom) {
		return classroomService.updateClassroom(classroomID, updateClassroom);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomID) {
		return classroomService.deleteClassroom(classroomID);
	}
}