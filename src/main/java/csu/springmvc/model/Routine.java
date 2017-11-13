package csu.springmvc.model;

import java.util.Set;

public class Routine {

  private int routineid;
  private String name;
  private Set<Exercise> exercises;
  
  public int getRoutineid() {
    return routineid;
  }

  public void setRoutineid(int routineid) {
    this.routineid = routineid;
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
}
