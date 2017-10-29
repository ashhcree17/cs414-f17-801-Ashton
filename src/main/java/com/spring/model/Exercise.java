package com.spring.model;

import java.time.Duration;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Exercise")
public class Exercise {
	@Id
	@GeneratedValue
	@Column(name="exerciseId")
	private Integer exerciseId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="duration")
	private Duration duration;
	
	@Column(name="numberOfSets")
	private Integer numberOfSets;
	
	@Column(name="repsPerSet")
	private Integer repsPerSet;
	
	@ManyToMany(mappedBy="exercises")
	private Set<Routine> routines;
	
	@ManyToMany(cascade = CascadeType.ALL)
	   @JoinTable(name = "Exercise_Equipment", 
	         joinColumns = { @JoinColumn(name = "exerciseID") }, 
	         inverseJoinColumns = { @JoinColumn(name = "equipmentId") })
	private Set<Equipment> equipment;

	/* Start of getters & setters */
	public Integer getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Integer getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(Integer numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	public Integer getRepsPerSet() {
		return repsPerSet;
	}
	public void setRepsPerSet(Integer repsPerSet) {
		this.repsPerSet = repsPerSet;
	}
	public Set<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(Set<Equipment> equipment) {
		this.equipment = equipment;
	}
	public Set<Routine> getRoutines() {
		return routines;
	}
	public void setRoutines(Set<Routine> routines) {
		this.routines = routines;
	}
	/* End of getters & setters */
}
