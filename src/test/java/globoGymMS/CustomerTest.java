package globoGymMS;

import org.junit.Assert;
import org.junit.Test;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;

public class CustomerTest {
	@Test
	public final void getStreet1() {
		Address a = new Address("123 Main St", "Apt 123", "Town", "CO", 12345);
		ArrayList<Routine> rs = new ArrayList<Routine>();
		ArrayList<Exercise> es = new ArrayList<Exercise>();

		Exercise e = new Exercise("E1", Duration.ofSeconds(120));
		es.add(e);
		
		Routine r = new Routine("R1", es);
		rs.add(r);
		
		Customer c = new Customer("Joe", "Blow", a, 1234567890, "joe@email.com", "C01",
				"Aetna", MembershipStatus.ACTIVE, rs);
		Assert.assertEquals(MembershipStatus.ACTIVE, c.getMembership());
	}
}
