package csu.springmvc.model;

import java.sql.Date;

public class WorkSchedule {

  private int workScheduleid;
  private Date day;
  private String startTime;
  private String endTime;
  
  public int getWorkScheduleid() {
    return workScheduleid;
  }

  public void setWorkScheduleid(int workScheduleid) {
    this.workScheduleid = workScheduleid;
  }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
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
