package globoGymMS;

import java.util.ArrayList;

public class RoutineBean {
	private Integer routineId;
	private String name;
	private ArrayList<Exercise> exercises;
	
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
}
