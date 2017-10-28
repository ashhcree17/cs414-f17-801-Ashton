package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Routine")
public class Routine {
	@Id
	@GeneratedValue  
	@Column(name="routineId")
	private Integer routineId;
	
	@Column(name="name")
	private String name;

	@Column(name="exercises")
	private ArrayList<Exercise> exercises;
	
	/* Start of getters & setters */
	public Integer getRoutineId() {
		return routineId;
	}
	public void setRoutineId(Integer routineId) {
		this.routineId = routineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}
	/* End of getters & setters */
}
