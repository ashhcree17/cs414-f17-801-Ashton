package globoGymMS;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="Customer")
public class Customer {
	@Id
	@SequenceGenerator(name="EMP_SEQ_2", allocationSize=1, initialValue=200)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")  
	@Column(name="id")
	private Integer id;			// REQUIRED, starts with 2
	
	@Column(name="name")
	private String name;			// REQUIRED, first name
	
	@Column(name="lastName")
	private String lastName;		// REQUIRED
	
	@Column(name="address")
	private Address address;
	
	@Column(name="phoneNumber")
	private Integer phoneNumber;	// Primary phone number
	
	@Column(name="email")
	private String email;		// REQUIRED
	
	@Column(name="insurance")
	private String insurance;
	
	@Column(name="membership")
	private MembershipStatus membership;
	
	@Column(name="name")
	private ArrayList<Routine> assignedRoutines;
	
	/* Start of getters & setters */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public MembershipStatus getMembership() {
		return membership;
	}
	public void setMembership(MembershipStatus membership) {
		this.membership = membership;
	}
	public ArrayList<Routine> getAssignedRoutines() {
		return assignedRoutines;
	}
	public void setAssignedRoutines(ArrayList<Routine> assignedRoutines) {
		this.assignedRoutines = assignedRoutines;
	}	
	/* End of getters & setters */
}
