

import java.time.Duration;

public class Exercise {
	private String name;
	private Duration duration;
	private Integer numberOfSets;
	private Integer repetitionsPerSet;
	
	// Creates an Exercise instance and sets its attributes
	// ***** THIS WILL NEED TO CHANGE SOMEHOW BC DUR, #OFSETS, & 
	// REPSPERSET ARE OPTIONAL 
	public Exercise(String name, Duration duration, Integer 
			numberOfSets, Integer repetitionsPerSet) {
		super();
		this.name = name;
		this.duration = duration;
		this.numberOfSets = numberOfSets;
		this.repetitionsPerSet = repetitionsPerSet;
	}
	
	/* Start of getters & setters */
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
	/* End of getters & setters */
}
