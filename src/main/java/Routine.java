

import java.util.ArrayList;

public class Routine {
	private String name;
	private ArrayList<Exercise> exercises;
	
	// Creates a Routine instance and sets its attributes
	public Routine(String name, ArrayList<Exercise> exercises) {
		super();
		this.name = name;
		this.exercises = exercises;
	}
	
	/* Start of getters & setters */
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
