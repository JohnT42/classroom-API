package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trainee {
	public Trainee(){	
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long traineeID;
	
	@Column(length = 100)
	private String trainee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Classroom classrm;

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTrainee() {
		return trainee;
	}

	public void setTrainee(String trainee) {
		this.trainee = trainee;
	}

	public Classroom getClassrm() {
		return classrm;
	}

	public void setClassrm(Classroom classrm) {
		this.classrm = classrm;
	}
	



	

}
