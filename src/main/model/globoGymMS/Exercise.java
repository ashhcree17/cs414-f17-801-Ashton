package main.model.globoGymMS;

import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	/* End of getters & setters */
}
