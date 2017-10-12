

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WorkSchedule {
	private DayOfWeek day;
	private LocalTime startTime;
	private LocalTime endTime;
	
	// Creates a WorkSchedule instance and sets its attributes
	public WorkSchedule(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
		super();
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/* Start of getters & setters */
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
