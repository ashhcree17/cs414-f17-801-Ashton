package com.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	   @JoinTable(name = "Routine_Exercise", 
	         joinColumns = { @JoinColumn(name = "routineID") }, 
	         inverseJoinColumns = { @JoinColumn(name = "exerciseId") })
	private Set<Exercise> exercises;
	
	@ManyToMany(mappedBy="assignedRoutines")
	private Set<Customer> customers;
	
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
	public Set<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	/* End of getters & setters */
}
