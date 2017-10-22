package globoGymMS;

import java.util.ArrayList;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="Routine")
public class Routine {
	private Integer routineId;
	private String name;
	private ArrayList<Exercise> exercises;
	
	// Creates a Routine instance and sets its attributes
	public Routine(Integer routineId, String name, ArrayList<Exercise> exercises) {
		super();
		this.routineId = routineId;
		this.name = name;
		this.exercises = exercises;
	}
	
	/* Start of getters & setters */
//	@Id
//	@GeneratedValue  
//	@Column(name="routineId")
	public Integer getRoutineId() {
		return routineId;
	}
	public void setRoutineId(Integer routineId) {
		this.routineId = routineId;
	}
//	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Column(name="exercises")
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}
	/* End of getters & setters */
}
