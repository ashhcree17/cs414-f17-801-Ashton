//package globoGymMS;
//
//import java.time.DayOfWeek;
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class ManagerTest {
//	Manager m;
//	
//	@Before 
//	public void setup() {
//		m = new Manager(000, "joeblow", "catsSHOPpretty361");
//    }
//	
//	@Test
//	public final void getUsername() {
//		Assert.assertEquals("joeblow", m.getUsername());
//	}
//	
//	@Test
//	public final void createIsSuccessful() {
//		Address a = new Address(001, "123 Main St", "Apt 123", "Town", "CO", 12345);
//		WorkSchedule w = new WorkSchedule(001, DayOfWeek.MONDAY, LocalTime.of(2, 00), 
//				LocalTime.of(8, 30));
//		Qualification q = new Qualification(001, "CPR-certified");
//		
//		ArrayList<WorkSchedule> ws = new ArrayList<WorkSchedule>();
//		ArrayList<Qualification> qs = new ArrayList<Qualification>();
//		ws.add(w);
//		qs.add(q);
//		
//		m.create(new Trainer(100, "Kyle", "Neal", a, 1234567890, "kyleneal@email.com", "Aetna", ws, qs));
//		
//	}
//}
