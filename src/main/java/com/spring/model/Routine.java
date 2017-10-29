package com.spring.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
    @JoinTable(name="Routine_Exercise")
	private ArrayList<Exercise> exercises;
	
	@ManyToMany(mappedBy="routine")
	private ArrayList<Customer> customers;
	
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
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	/* End of getters & setters */
}
