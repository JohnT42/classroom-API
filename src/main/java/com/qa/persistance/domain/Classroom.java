package com.qa.persistance.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	public Classroom() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomID;

	@Column(length = 100)
	private String trainer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classrm",fetch=FetchType.EAGER)
	private List<Trainee> trainees;
	
	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	

}
