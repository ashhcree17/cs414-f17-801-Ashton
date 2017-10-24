package globoGymMS;

import java.time.Duration;

public class ExerciseBean {
	private Integer exerciseId;
	private String name;
	private Duration duration;
	private Integer numberOfSets;
	private Integer repetitionsPerSet;
	
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
	public Integer getRepetitionsPerSet() {
		return repetitionsPerSet;
	}
	public void setRepetitionsPerSet(Integer repetitionsPerSet) {
		this.repetitionsPerSet = repetitionsPerSet;
	}
}
