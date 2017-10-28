package model;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WorkSchedule")
public class WorkSchedule {
	@Id
	@GeneratedValue  
	@Column(name="workScheduleId")
	private Integer workScheduleId;
	
	@Column(name="day")
	private DayOfWeek day;
	
	@Column(name="startTime")
	private LocalTime startTime;
	
	@Column(name="endTime")
	private LocalTime endTime;
	
	/* Start of getters & setters */
	public Integer getWorkScheduleId() {
		return workScheduleId;
	}
	public void setWorkScheduleId(Integer workScheduleId) {
		this.workScheduleId = workScheduleId;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	/* End of getters & setters */
}
