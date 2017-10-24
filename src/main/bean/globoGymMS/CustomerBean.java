package globoGymMS;

import java.util.ArrayList;

public class CustomerBean {
	private Integer id;			// Starts with 2
	private String name;			// First name
	private String lastName;
	private Address address;
	private Integer phoneNumber;	// Primary phone number
	private String email;
	private String insurance;
	private MembershipStatus membership;
	private ArrayList<Routine> assignedRoutines;
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
}
