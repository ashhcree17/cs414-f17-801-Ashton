package csu.springmvc.model;

public class WorkSchedule {

  private int workScheduleid;
  private String day;
  private String startTime;
  private String endTime;
  
  public int getWorkScheduleid() {
    return workScheduleid;
  }

  public void setWorkScheduleid(int workScheduleid) {
    this.workScheduleid = workScheduleid;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
}
