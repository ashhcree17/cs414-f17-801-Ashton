package csu.springmvc.model;

public class Exercise {

  private int exerciseid;
  private String name;
  private int duration;
  private int numberOfSets;
  private int repsPerSet;
  
  public int getExerciseid() {
    return exerciseid;
  }

  public void setExerciseid(int exerciseid) {
    this.exerciseid = exerciseid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getNumberOfSets() {
    return numberOfSets;
  }

  public void setNumberOfSets(int numberOfSets) {
    this.numberOfSets = numberOfSets;
  }

  public int getRepsPerSet() {
    return repsPerSet;
  }

  public void setRepsPerSet(int repsPerSet) {
    this.repsPerSet = repsPerSet;
  }
}
