

import java.util.ArrayList;

public class Customer {
	private String name;		// first name
	private String lastName;
	private Address address;
	private Integer phoneNumber;	// primary phone number
	private String email;
	private String id;
	private String insurance;
	private MembershipStatus membership;
	private ArrayList<Routine> assignedRoutines;
	
	// Creates a Customer instance and sets its attributes
	public Customer(String name, String lastName, Address address, 
			Integer phoneNumber, String email, String id, String insurance,
			MembershipStatus membership, ArrayList<Routine> assignedRoutines) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.id = id;
		this.insurance = insurance;
		this.membership = membership;
		this.assignedRoutines = assignedRoutines;
	}
	
	/* Start of getters & setters */
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
