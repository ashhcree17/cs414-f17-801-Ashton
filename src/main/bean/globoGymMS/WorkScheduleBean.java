package globoGymMS;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WorkScheduleBean {
	private Integer workScheduleId;
	private DayOfWeek day;
	private LocalTime startTime;
	private LocalTime endTime;
	
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
}
