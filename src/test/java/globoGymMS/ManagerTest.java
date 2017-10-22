package globoGymMS;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {	
	@Test
	public final void getUsername() {
		Manager m = new Manager(000, "joeblow", "catsSHOPpretty361");
		
		Assert.assertEquals("joeblow", m.getUsername());
	}
	
//	@Test
//	public final void getEmail() {
//		Address a = new Address("123 Main St", "Apt 123", "Town", "CO", 12345);
//		ArrayList<Routine> rs = new ArrayList<Routine>();
//		ArrayList<Exercise> es = new ArrayList<Exercise>();
//
//		Exercise e = new Exercise("E1", Duration.ofSeconds(120));
//		es.add(e);
//		
//		Routine r = new Routine("R1", es);
//		rs.add(r);
//		
//		Manager m = new Manager(001, "Joe", "Blow", a, 1234567890, "joe@email.com", "Aetna");
//		
//		Assert.assertEquals("joe@email.com", m.getEmail());
//	}
}
